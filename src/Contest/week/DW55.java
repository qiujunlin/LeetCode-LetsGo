package Contest.week;

public class DW55 {
    public static void main(String[] args) {

    }
    public boolean canBeIncreasing(int[] nums) {
        int a[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int k  =0;
            for (int j = 0; j < a.length; j++) {
                if(k==i) k++;
                 a[j] =  a[k];
                 k++;
            }
             if(judge(a,i)) {
                  return   true;
             }
        }
        return  false;
    }

    private boolean judge(int[] nums, int i) {
        for (int j = 0; j < nums.length; j++) {
             if(j+1<nums.length&&nums[j]>=nums[j+1]) return  false;
        }
        return  true;
    }
    public String removeOccurrences(String s, String part) {
        StringBuffer stringBuffer  = new StringBuffer(s);
        while (stringBuffer.indexOf(part)!=-1){
             int index = stringBuffer.indexOf(part);
             StringBuffer ne  = stringBuffer.replace(index,index+part.length(),"");
             stringBuffer = ne;
        }
        return  stringBuffer.toString();


    }
    public long maxAlternatingSum(int[] nums) {

         int max  =0;
         int i = 1;
         long res  =0;
        while(i<nums.length){
            if(i+1<nums.length&&nums[i]<=nums[i+1]){
                i++;
            }
            if(i==nums.length-1){
                res+=nums[i];
                return res;
            }
            break;
        }

         while (i<nums.length){
             int min = i;
             while (i+1<nums.length&&nums[i]>=nums[i+1]){
                 i++;
                 min = nums[i];
             }
             if(i!=nums.length)
             res+= max - min;
             while (i+1<nums.length&&nums[i]<=nums[i+1]){
                 i++;
             }
             if(i!=nums.length){
                 max = i;
             }
         }
         if(i==nums.length-1){
             res+=nums[nums.length-1];
         }
         return  res;

    }



}
