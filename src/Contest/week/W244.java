package Contest.week;

import java.util.TreeMap;

public class W244 {
    public static void main(String[] args) {
        System.out.println("dha");
    }
    public static int[][] change(int [][]matrix){
        int [][]temp=new int[matrix[0].length][matrix.length];
        int dst=matrix.length-1;
        for(int i=0;i<matrix.length;i++,dst--){
            for(int j=0;j<matrix[0].length;j++){
                temp[j][dst]=matrix[i][j];
            }
        }
        return temp;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int t=0;t<4;t++) {
            int[][] temp = new int[mat.length][mat.length];
            int d = mat.length - 1;
            for (int i = 0; i < mat.length; i++, d--) {
                for (int j = 0; j < mat.length; j++) {
                    temp[j][d] = mat[i][j];
                }
            }
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    if(target[i][j]!=temp[i][j])         return  false;
                }

            }
        }

        return  true;

    }
    public int reductionOperations(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int num:nums) {
            if(!map.containsKey(num))map.put(num,1);
            else map.put(num,map.get(num)+1);
        }
        int resv=0;
        while (map.size()>1){
            int  a  = map.lastKey();
            map.remove(a);
            int b = map.lastKey();
            map.put(a,map.get(b)+a);
            resv +=  map.get(a);
        }
        return  resv;

    } public int minFlips(String s) {
        char ch[] = s.toCharArray();

        int len = ch.length;
        int counts[] = new int[len*2];
        s= s+s;
        StringBuffer stringBuffer = new StringBuffer(s);
        int count  =0;
        char cur  =0;
        char pre= 0;
        int res= Integer.MAX_VALUE;
        pre=stringBuffer.charAt(0);
        for(int i=1;i<len*2;i++){
            cur = stringBuffer.charAt(i);
            if(cur=='1'&&pre=='1'){
                pre  ='0';
                count++;
            }else if(cur=='0'&&pre=='0'){
                pre ='1';
                count++;
            }else{
                pre =stringBuffer.charAt(i);
            }
            if(i-len>=0){
                res =Math.min(count-counts[i-len],res);
            }
            counts[i] = count;

        }
        return  count;


    }


}
