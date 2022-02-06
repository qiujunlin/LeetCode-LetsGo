package Contest.week;

public class Bitset {
    int nums[];
    int c =0;
    boolean judge =true; // true  正常 false 反过来
    public Bitset(int size) {
        nums =new int[size];
    }

    public void fix(int idx) {
        if(judge) {
            if(nums[idx]==0) c++;
            nums[idx] =1;
        }else {
            if(nums[idx]==1) c++;
            nums[idx] =0;
        }

    }

    public void unfix(int idx) {
        if(judge) {
            if(nums[idx]==1) c--;
            nums[idx] =0;
        }else {
            if(nums[idx]==0) c--;
            nums[idx] =1;
        }
    }

    public void flip() {
        judge =!judge;
        c =nums.length-c;
    }

    public boolean all() {
      return   c==nums.length;
    }

    public boolean one() {

            return  c>0;
    }

    public int count() {
      return   c;
    }

    public String toString() {
        StringBuilder s =new StringBuilder();
        for (int i = 0; i <nums.length ; i++) {
            if(judge) {
                s.append(i);
            } else{
                s.append(i==0?1:0);
            }

        }
        return  s.toString();
    }
}
}
