package Test.IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class GroupChatServer {
  private Selector selector ;
  private ServerSocketChannel serverSocketChannel;
  public  static  final  int PORT = 6666;
  public  GroupChatServer(){
      try{
          this.selector = Selector.open();
          this.serverSocketChannel =  ServerSocketChannel.open();
          this.serverSocketChannel.bind(new InetSocketAddress("127.0.0.1",PORT));
          serverSocketChannel.configureBlocking(false);
          serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
      }catch (Exception e){
          e.printStackTrace();
      }
  }
    /**
     * 监听，并且接受客户端消息，转发到其他客户端
     */
    public void listen() {
        try {
            while (true) {
                //获取监听的事件总数
                int count = selector.select(2000);
                if (count > 0) {
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    //获取SelectionKey集合
                    Iterator<SelectionKey> it = selectionKeys.iterator();
                    while (it.hasNext()) {
                        SelectionKey key = it.next();
                        //如果是获取连接事件
                        if (key.isAcceptable()) {
                            SocketChannel socketChannel = serverSocketChannel.accept();
                            //设置为非阻塞
                            socketChannel.configureBlocking(false);
                            //注册到选择器中
                            socketChannel.register(selector, SelectionKey.OP_READ);
                            System.out.println(socketChannel.getRemoteAddress() + "上线了~");
                        }
                        //如果是读就绪事件
                        if (key.isReadable()) {
                            //读取消息，并且转发到其他客户端
                            readData(key);
                        }
                        it.remove();
                    }
                } else {
                    System.out.println("等待...");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取客户端发送过来的消息
    private void readData(SelectionKey selectionKey) {
        SocketChannel socketChannel = null;
        try {
            //从selectionKey中获取channel
            socketChannel = (SocketChannel) selectionKey.channel();
            //创建一个缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //把通道的数据写入到缓冲区
            int count = socketChannel.read(byteBuffer);
            //判断返回的count是否大于0，大于0表示读取到了数据
            if (count > 0) {
                //把缓冲区的byte[]转成字符串
                String msg = new String(byteBuffer.array());
                //输出该消息到控制台
                System.out.println("from 客户端：" + msg);
                //转发到其他客户端
                notifyAllClient(msg, socketChannel);
            }
        } catch (Exception e) {
            try {
                //打印离线的通知
                System.out.println(socketChannel.getRemoteAddress() + "离线了...");
                //取消注册
                selectionKey.cancel();
                //关闭流
                socketChannel.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * 转发消息到其他客户端
     * msg 消息
     * noNotifyChannel 不需要通知的Channel
     */
    private void notifyAllClient(String msg, SocketChannel noNotifyChannel) throws Exception {
        System.out.println("服务器转发消息~");
        for (SelectionKey selectionKey : selector.keys()) {
            Channel channel = selectionKey.channel();
            //channel的类型实际类型是SocketChannel，并且排除不需要通知的通道
            if (channel instanceof SocketChannel && channel != noNotifyChannel) {
                //强转成SocketChannel类型
                SocketChannel socketChannel = (SocketChannel) channel;
                //通过消息，包裹获取一个缓冲区
                ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
                socketChannel.write(byteBuffer);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        GroupChatServer chatServer = new GroupChatServer();
        //启动服务器，监听
        chatServer.listen();
    }


}
