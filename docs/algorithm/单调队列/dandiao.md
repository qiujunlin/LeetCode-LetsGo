## 1438 绝对值差不超过限制的最长连续子数组

[题解](https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/solution/he-gua-de-shu-ju-jie-gou-hua-dong-chuang-v46j/)

[题解二](https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/solution/jue-dui-chai-bu-chao-guo-xian-zhi-de-zui-5bki/)

### 解法一 TreeMap 碉堡了！

```java
class Solution {
      public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer,Integer> map = new TreeMap<>((a,b)->b-a);
        int left =0;
       int  res = 0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while (map.firstKey()-map.lastKey()>limit){ 
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0) map.remove(nums[left]);
                left++;
            }
            res = Math.max(i-left+1,res);
        }
        return res;
                


    }
}
```



### 解法二  单调栈

```java
class Solution {
    public int longestSubarray(int[] nums, int limit) {
       Deque<Integer> max  = new LinkedList<>();
            Deque<Integer> min =  new LinkedList<>();
            int left = 0;
            int res  = 0 ;
            for(int i =0;i<nums.length;i++){
              while(!max.isEmpty() && nums[max.getLast()]<nums[i]){
                  max.removeLast();
              }
              while(!min.isEmpty() && nums[min.getLast()]>nums[i]){
                    min.removeLast();
              }
              max.offerLast(i);
              min.offerLast(i);
              while (!max.isEmpty() && !min.isEmpty() && nums[max.peek()]-nums[min.peek()] > limit){
                  if(max.peek() <= left) max.poll();
                  if(min.peek() <= left) min.poll();
                  left++;
              }
              res = Math.max(res,i-left+1);
              
            }
            return  res;
    }
}
```

