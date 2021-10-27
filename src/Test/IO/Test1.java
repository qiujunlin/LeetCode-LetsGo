package Test.IO;

import com.sun.org.apache.bcel.internal.ExceptionConst;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test1 {


    private long transferFile(File source, File des) throws IOException {
        long startTime = System.currentTimeMillis();

        if (!des.exists())
            des.createNewFile();

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(des));

        //FileChannel readChannel = bis.getChannel();
        //将数据源读到的内容写入目的地--使用数组
        byte[] bytes = new byte[1024 * 1024];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private long transferFileWithNIO(File source, File des) throws IOException {
        long startTime = System.currentTimeMillis();

        if (!des.exists())
            des.createNewFile();

        RandomAccessFile read = new RandomAccessFile(source, "rw");
        RandomAccessFile write = new RandomAccessFile(des, "rw");

        FileChannel readChannel = read.getChannel();
        //FileChannel readChannel = read.getChannel();
        FileChannel writeChannel = write.getChannel();


        ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);//1M缓冲区

        while (readChannel.read(byteBuffer) > 0) {
            byteBuffer.flip();
            writeChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        writeChannel.close();
        readChannel.close();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void main(String[] args) throws IOException {
            Test1 test1 = new Test1();
        File sourse = new File("F:\\av.mp4");
        File des = new File("F:\\io.mp4");
        File nio = new File("F:\\nio.mp4");

        long time = test1.transferFile(sourse, des);
        System.out.println(time + "：普通字节流时间");

        long timeNio = test1.transferFileWithNIO(sourse, nio);
        System.out.println(timeNio + "：NIO时间");


    }
    void fun1() throws Exception {

        // 创建FileInputStream对象，构造方法中绑定要读取的效据源。
        FileInputStream fis = new FileInputStream(
                "F:/1.txt"
        );

        // 创建BufferedInputStream对象，构造方法中传递FileInputStream对象，提高FileInputsStream对象的读取效率
        BufferedInputStream bis = new BufferedInputStream(fis);

        // 使用BufferedInputStream对象中的方法read，读取文件。
        // 创建FileOutputStream对象，构造方法中绑定要输出的目的地。
        FileOutputStream fos = new FileOutputStream("F:/2.txt", true);

        // 创建BufferedOutputStream对象，构造方法中传递FileOutputStream对象，提高FileOutputStream对象效率。
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int read =0;
        while ((read=bis.read())!=-1) {
            // 使用BufferedOutputStream对象中的方法write，把数据写入到内部冲区中。
            bos.write(read);
        }

        // 使用BufferedOutputStream对象中的方法flush，把内部冲区中的数据，刷新到文件中。
        bos.flush();
        // 释放资源（会先调用flush方法刷新数据，第4步可以省略）。
        bos.close();
        fos.close();
        bis.close();
        fis.close();
    }
}
