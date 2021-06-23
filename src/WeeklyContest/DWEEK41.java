package WeeklyContest;

public class DWEEK41 {
    public int countConsistentStrings(String allowed, String[] words) {
        int hash[] = new int[26];
        for (int i = 0; i < allowed.length(); i++) {
            hash[allowed.charAt(i)-'a']++;
        }
        int coutn  =0;
        for(String s:words){
            int i=0;
            for (; i < s.length(); i++) {
                if(hash[s.charAt(i)-'a']==0) break;
            }
            if(i==s.length()) coutn++;


        }
        return  coutn;

    }
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int pre[] =new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        int res[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int sum =0;
            sum+=((i)*nums[i]-pre[i]);
            sum+=(pre[nums.length]-pre[i+1]-(nums.length-1-i)*nums[i]);
            res[i] =sum;
        }
        return  res;

    }
}
