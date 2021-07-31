package Test;

import java.io.*;
import java.util.*;

public  class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader("D:\\input.txt"));//要读取的文本文件
        BufferedWriter br = new BufferedWriter(new FileWriter("D:\\out.txt"));//输出的结果文件
        String s = "";
        ArrayList<String> list = new ArrayList<>();
        while ((s = in.readLine()) != null) {
            list.add(s);
        }
        Collections.sort(list);
        for (int j = 0; j < list.size(); j++) {
            br.write(list.get(j));
            br.write("\n");
        }
        //关闭
        in.close();
        br.flush();
        br.close();
    }
}

