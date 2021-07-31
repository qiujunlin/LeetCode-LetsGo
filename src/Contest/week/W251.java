package Contest.week;
import java.util.*;

public class W251 {
   static interface  demo{
        void  tets();
    }
    class Unino{

    }
    public static void main(String[] args) {
        System.out.println("hdashd");

        get1(Unino.class);
    }
    static  void get1(Class<?> inte){
        inte.toString();
        System.out.println(inte.getCanonicalName());
    }
    public int getLucky(String s, int k) {
        StringBuffer ss = new StringBuffer();
        for (int i = 0; i <s.length() ; i++) {
            ss.append(s.charAt(i)-'a'+1);
        }
        int res  =0;
        while (k>0){
            for (int i = 0; i <ss.length() ; i++) {
                res+=ss.charAt(i)-'0';
            }
            ss=new StringBuffer(String.valueOf(res));
            res =0;
        }
        return  res;

    }
    boolean vis1[] ;
    boolean vis2[] ;
    int max =0;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        vis1 = new boolean[students.length];
        vis2 = new boolean[students.length];
        dfs(students,mentors,0,0);
        return  max;
    }

    private void dfs(int[][] students, int[][] mentors, int i,int res) {
        if(i==students.length) {
            max =Math.max(res,max);
            return;
        }
        for(int j = 0; j < students.length ;j++) {
           if(!vis2[j]) {
               vis2[j] = true;
               int a = get(students[i],mentors[j]);
               dfs(students,mentors,i+1,res+a);
               vis2[j] =false;
           }
        }
    }
    private int get(int[] student, int[] mentor) {
        int res  =0;
        for (int i = 0; i < student.length; i++) {
            if(student[i]==mentor[i]) res++;
        }
        return  res;
    }


}
