package leetcode;

public class Q307 {
        int nums[];
     int tree[];
     int len ;

    public Q307(int[] nums) {
        len = nums.length;
        tree = new int[len];
        this.nums = nums;
        for(int i=0;i<len;i++){
            update(i,nums[i]);
        }
    }

    public void update(int index, int val) {
         add(index,val-nums[index]);
         nums[index] = val;
    }

    public int sumRange(int left, int right) {
     return  query(right+1) - query(left);
    }
    public  void add(int index, int val){
        for(int i=index;i<len;i+=lowbit(i)){
            tree[i] += val;
        }
    }
    public  int query(int x){
        int res  =0;
        for(int i =x;i>0;i-=lowbit(i)){
            res += tree[i];
        }
        return  res;
    }
    public  int lowbit(int x){
        return x&-x;
    }
}
