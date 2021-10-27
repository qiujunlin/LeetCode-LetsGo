package Test.IO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class NIOClient {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 6666);
        socketChannel.configureBlocking(false);
        //连接服务器
        boolean connect = socketChannel.connect(address);
        //判断是否连接成功
        if(!connect){
            //等待连接的过程中
            while (!socketChannel.finishConnect()){
                System.out.println("连接服务器需要时间，期间可以做其他事情...");
            }
        }
        while (true) {
            Scanner sc = new Scanner(System.in);

            String msg = sc.nextLine();
            ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
            //把byteBuffer数据写入到通道中
            socketChannel.write(byteBuffer);
            //让程序卡在这个位置，不关闭连接
        }
        //System.in.read();
    }
}
