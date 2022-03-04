package template;

import java.util.Random;

public class Fload {
    static int max= 100000;
    public static void main(String[] args) {
        Random ran = new Random();
        int dis[][] = new int[10000][10000];
        for (int i = 0; i < dis.length; i++) {
            for (int j = 0; j < dis.length; j++) {
                dis[i][j] = ran.nextInt(10000);
            }
        }
        int dist[][] = {
                { 0, 2, 3, 6, max, max },
                { 2, 0, max, max,4, 6 },
                { 3, max, 0, 2, max, max },
                { 6, max, 2, 0, 1, 3 },
                { max, 4, max, 1, 0, max },
                { max, 6, max, 3, max, 0 } };// 地图
        fload(dis);
        // 输出
        for (int i = 0; i < dis.length; i++) {
            System.out.print("节点"+(i+1)+" 的最短路径");
            for (int j = 0; j < dis.length; j++) {
                System.out.print(dis[i][j]+" ");
            }
            System.out.println();
        }

    }
   static void fload(int dist[][]){
        int len = dist.length;
        for(int k=0;k<len;k++){
            for (int i=0;i<len;i++){
                for(int j=0;j<len;j++){
                    dist[i][j] =Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
    }
}
