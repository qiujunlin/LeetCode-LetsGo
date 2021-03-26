package TU;

import java.util.*;

/**
 * @Classname Djis
 * @Description:
 * @Date 2021/3/24 23:44
 * @Created by qiujunlin
 */
public class Djis {
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        HashSet<Integer> set = new HashSet<>();

        int node[][] = new int[7][7];
        for(int i=0;i<7;i++){
            node[i][i]=0;
            for(int j =0;j<7;j++){
                node[i][j] =100000;

            }
        }
        node[0][1]=12;node[1][0]=12;
        node[1][2]=10;node[2][1]=10;
        node[0][6]=14;node[6][0]=14;
        node[0][5]=16;node[5][0]=16;
        node[1][5]=7;node[5][1]=7;
        node[2][3]=3;node[3][2]=3;
        node[2][5]=6;node[5][2]=6;
        node[2][4]=5;node[4][2]=5;
        node[3][4]=4;node[4][3]=4;
        node[4][5]=2;node[5][4]=2;
        node[4][6]=8;node[6][4]=8;
        node[5][6]=9;node[6][5]=9;
        // int res[]= new Main().dijiskra(node,0);
        String vs[] = {"A","B","C","D","E","F","G"};
        int res[] = new Djis().dijiskra(node,0,vs);
        for(int i=0;i<7;i++){
            System.out.print(res[i]+" ");
        }
    }
    int[] dijiskra(int node[][],int v,String vs[]){
        int len = node.length;
        int dist[] = new int[len];
        String s[] = new String[len];
        int []pre = new int[len];

        for(int i=1;i<7;i++) {
            dist[i]=node[v][i];
            pre[i] = 0;
        }
        boolean vis[] =  new boolean[len];

        vis[v] = true;
        //i是循环次数
        for(int i=0;i<len-1;i++){
            //寻找最小值
            int min = -1;
            for(int j =0;j<len;j++){
                if(!vis[j]&&(min==-1||dist[j]<dist[min])){
                    min=j;
                }
            }
            // vis[min] = true;
            //更新节点距离
            for(int j=0;j<len;j++){
                //dist[j] = Math.min(dist[j],dist[min]+node[min][j]);
                int dis = node[min][j]==Integer.MAX_VALUE?node[min][j]:node[min][j]+dist[min];
                if(!vis[j]&&dis<dist[j]){
                    dist[j]=dis;
                    pre[j]=min;
                }
            }
            //加入这个节点
            vis[min] =true;
        }
        return dist;
    }
}
