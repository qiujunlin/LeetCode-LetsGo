package Contest;

import java.util.*;

/*

删除一次得到的最大和 ：
前缀和 + 维护滑动窗口为k+1  内的最小值

 */
public class Byte {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n =  scanner.nextInt();
        int k =  scanner.nextInt();
        int nums[] =new int[n];
        for (int i = 0; i <n ; i++) {
            nums[i] =scanner.nextInt();
        }


        //h滑窗  维护最小值
        int presum[] =new int[n+1];
        int sum =0;
        for (int i = 0; i <=k ; i++) {
            sum +=  nums[i];
        }
        presum[k] =sum;
        for (int i = k+1; i <n ; i++) {
            sum+= nums[i];
            sum-=nums[i-k-1];
            presum[i] =  sum;
        }
        int i =0;
        LinkedList<Integer> q=new LinkedList<>();

        for (int j = 0; j <=k ; j++) {

            while (!q.isEmpty() && nums[j] < nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offerLast(j);
        }


        int max =0;
        max =Math.max(max,presum[k] -nums[q.peekFirst()]);
        for (int j = k+1; j <n ; j++) {
            while (!q.isEmpty() && nums[j] < nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offerLast(j);
            while (q.peekFirst()<=j-(k+1)){
                q.pollFirst();
            }
            max =Math.max(max,presum[j] -nums[q.peekFirst()]);
        }
        System.out.println(max);
    }
}

/**
 * 数字乘积
 * 使用 数字的 指数位置来维护最大值
 */
class Main1 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int t = scanner.nextInt();
        HashMap<Integer,Integer> map =new HashMap<>();
        map.put(1,0);
        map.put(2,1);
        map.put(4,2);
        map.put(8,3);
        map.put(16,4);
        map.put(32,5);
        map.put(64,6);
        map.put(128,7);
        map.put(256,8);
        map.put(512,9);
        map.put(1024,10);
        while (t>0){
            int n =scanner.nextInt();
            int nums[] = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] =scanner.nextInt();
            }
            int i =0;
            int max  =0;
            int s =0;int e = 0;
            while (i<n){
                while (i<n&&nums[i]==0) i++;
                int res =0;
                int start = i;
                while (i<n&&nums[i]!=0) {
                    res = res +  map.get(nums[i]);
                    i++;
                }
                if(res>max){
                    s =start;
                    e =i-1;
                    while(e>s&&nums[e]==1){
                        e--;
                    }
                    max =res;

                }
            }
            System.out.println((s+1)+" "+(e+1));
            t--;
        }

    }

}

/**
 * 特征加工 ：
 * 拓扑排序
 */

class Main2 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> l = new ArrayList<>();
        HashMap<Integer,ArrayList<Integer>> map =new HashMap<>();
        scanner.nextLine();
        int i = 1;
        while (i<=n){
            String s =scanner.nextLine();
            String strs[] =s.split(" ");
            if(i==1) {
                for(String t:strs){
                    l.add(Integer.valueOf(t));
                }
            }else{
                int num = Integer.valueOf(strs[0]);
                map.put(num,new ArrayList<>());
                for (int j = 1; j <strs.length ; j++) {
                    map.get(num).add(Integer.valueOf(strs[j]));
                }
            }
            i++;
        }
        int in[] =new int[10];
        for(int key :map.keySet() ){
            ArrayList<Integer> list =map.get(key);
            for(int num : list){
                in[num]++;
            }
        }
        //System.out.println(map);
        LinkedList<Integer> q =new LinkedList<>();
        for (int j = 0; j < in.length; j++) {
            if(in[j]==0){
                q.offerLast(j);
            }
        }
        // System.out.println(q);
        while (!q.isEmpty()){
            int num =q.pollFirst();
            if(map.get(num)==null)continue;
            for(int c : map.get(num)){
                in[c]--;
                if(in[c]==0){
                    q.offerLast(c);
                }
            }
        }
        HashSet<Integer> set =new HashSet<>();
        for (int j = 0; j <in.length ; j++) {
            if(in[j]!=0) {
                set.add(j);
            }
        }
        for(int num : l){
            if(dfs(set,map,num)){
                System.out.print(0+" ");
            }else{
                System.out.print(1+" ");
            }
        }



    }

    private static boolean dfs(HashSet<Integer> set, HashMap<Integer, ArrayList<Integer>> map, int num) {
        if(map.get(num)==null) return  false;
        for(int a : map.get(num)){
            if(set.contains(a)){
                return  true;
            }else{
                if(dfs(set,map,a)) return  true;
            }
        }
        return  false;

    }

}

/**
 * 翻转连续子数组最大和
 *  为每个数字维护左右两边连续子数组的最大值
 */

class Main3 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int  n =scanner.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i <n ; i++) {
            nums[i] =scanner.nextInt();
        }
        int dp1[] =new int[n+1];
        int dp2[] =new int[n+1];
        int sum  =0;

        for (int i = 0; i <n ; i++) {
            sum =Math.max(sum+nums[i],nums[i]);
            dp1[i] =sum;
        }
        sum =0;
        for (int i = n-1; i >=0 ; i--) {
            sum =Math.max(sum+nums[i],nums[i]);
            dp2[i] =sum;
        }

        int dp3[] =new int[n+1];
        int dp4[] =new int[n+1];
        int max =0;
        for (int i = 1; i <=n ; i++) {
            max =Math.max(dp1[i-1],max);
            dp3[i] =max;
        }
        max =0;
        for (int i = n-1; i >=0 ; i--) {
            max =Math.max(dp2[i+1],max);
            dp4[i] =max;
        }
        max =0;
        for (int i = 0; i < n; i++) {
            max =Math.max(dp3[i]+dp4[i],max);
            max =Math.max(dp3[i+1]+dp4[i],max);
            max =Math.max(dp3[i]+dp4[i+1],max);
        }
        System.out.println(max);



    }


}



