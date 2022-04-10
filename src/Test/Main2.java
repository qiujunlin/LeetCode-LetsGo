package Test;


import org.omg.CORBA.INTERNAL;

import java.util.*;

public class Main2   {
    public static void main(String[] args)  {
        Scanner s =new Scanner(System.in);
        int t  =  s.nextInt();
        ArrayList<Integer> res =new ArrayList<>();
        while (t>0){
            int n  = s.nextInt();
            int m  =s.nextInt();
            s.nextLine();
            char ch[][] =  new char[n][m];
            for (int i = 0; i <n ; i++) {
                ch[i] = s.nextLine().toCharArray();
            }
            t--;
            res.add(getMinStep(ch,n,m));
        }
        for(int a :res) {
            System.out.println(a);
        }
    }
    static   int dir[][]= {{1,2,0,1},{2,1,1,0},{2,-1,1,0}, {1,-2,0,-1},{-1,-2,0,-1},{-2,-1,-1,0},{-2,1,-1,0},{-1,2,0,1}};
    private static int getMinStep(char[][] ch,int m,int n) {
        int tx=0,ty=0;
        Queue<int[]>  q =new LinkedList<>();
        boolean vis[][] =new boolean[m][n];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
                if(ch[i][j]=='K') {
                     vis[i][j]=true;
                     q.offer(new int[]{i,j});
                }else if(ch[i][j]=='T'){
                      tx = i;ty =j;
                }
            }
        }
        int step = 1;
        out:  while (!q.isEmpty()){
            int size =  q.size();
            for (int i = 0; i < size; i++) {
                int a[] =q.poll();
                for (int t[] : dir) {
                    int x = t[0] + a[0];
                    int y = t[1] + a[1];
                    int u = t[2] + a[0];
                    int v = t[3] + a[1];
                    if (x >= 0 && y >= 0 && x < m && y < n && ch[u][v] != '0' && ch[x][y]!='0'&&!vis[x][y]) {
                        q.offer(new int[]{x,y});
                        vis[x][y]=true;
                        if(x==tx&&y==ty)  break out;

                    }
                }
            }
            step++;
        }
        return   q.isEmpty()?-1:step;
    }

}

