package Contest.week;

import java.util.HashSet;
import java.util.LinkedList;

public class Week238 {
    public static void main(String[] args) {
        System.out.println("haha");
    }

    public int maxFrequency(int[] nums, int k) {
          int res = 0;
          int sum =0;
          int right =0;
          int left =0;
          int len = nums.length;
          while (right<len){
              sum+=nums[right];
              while (nums[right]*(right-left+1)-sum>k){
                  left++;
                  sum-=nums[left];
              }
              res = Math.max(res,right-left+1);
              right ++;
          }
          return  res;
    }
    public int sumBase(int n, int k) {
        int res  =0;
        while(n!=0){
            res+=n/k;
            n=n%k;
        }
        return  res;
    }
    public int longestBeautifulSubstring(String word) {

     int index = 0;
     int len  =word.length();
     char ch[] = word.toCharArray();
     int res=0;
     while(index<len){
         while(index<len&&ch[index]!='a') index++;
         if(index<len&&ch[index]=='a'){
             int l =index;
             while (ch[index]=='a'){
                 index++;
             }
             if(index<len&&ch[index]=='e') {
                 while (index < len && ch[index] == 'e') index++;
             }else continue;
             if(index<len&&ch[index]=='i') {
                 while (index<len&&ch[index]=='i') index++;
             }else {
                 continue;
             }
             if(index<len&&ch[index]=='o') {
                 while (index<len&&ch[index]=='o') index++;
             }else {
                 continue;
             }
             if(index<len&&ch[index]=='u') {
                 while (index<len&&ch[index]=='u') index++;
             }else {
                 continue;
             }
             res= Math.max(res,index-l);
         }
     }
 return res;
    }
    public int longestBeautifulSubstring1(String word) {
        int max =1;
        int right =0;
        int left =0;
        int len  =word.length();
        LinkedList<Character> linkedList = new LinkedList<>();
        HashSet<Character> set = new HashSet<>();
        while(right<len){
            char c = word.charAt(right);
            if(linkedList==null||c>=linkedList.getLast()){
                linkedList.addLast(c);
                set.add(c);
                if(set.size()==5) {
                    max = Math.max(max,linkedList.size());
                }
            }else{
                linkedList.clear();
                set.clear();
                linkedList.addLast(c);
                set.add(c);
            }
            right++;
        }
        return max;
    }
}
