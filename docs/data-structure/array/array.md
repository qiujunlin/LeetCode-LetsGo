## 已解决题目列表



| 题目 | 名称     | 解法   | 难度   |
| ---- | -------- | ------ | ------ |
| 1    | 两数之和 | hash   | easy   |
| 15   | 三数之和 | 双指针 | middle |
|      |          |        |        |

## 1.两数之和



##### 解法一 时间复杂度O(n^2)



很简单 ，暴力循环、这里贴下我一年前第一次刷题 ，使用C语言做的第一道题代码，当时只想到暴力解决，甚是怀念。

```c
int* twoSum(int* nums, int numsSize, int target, int* returnSize){
         int i,j;
         static int a[2];
         for(i=0;i<numsSize;i++){
             for(j=i+1;j<numsSize;j++){
                 if((nums[i]+nums[j])==target){
                     a[0]=i;
                     a[1]=j;
                     *returnSize=2;
                 }
             }
         }
         return  a;
}
```



##### 解法二  时间	O(1)

使用hash表，

```java
   public int[] twoSum(int[] nums, int target) {
         Map<Integer,Integer> map = new HashMap<>();
         for(int i=0;i<nums.length;i++){
           if(map.containsKey(target-nums[i])){
             return new int[]{map.get(target-nums[i]),i};
           }
           map.put(nums[i],i);
         }
         return new int[2];
    }
```



## 15. 三数之和

##### 解法：排序加双指针

1. 对数组排序

2. 遍历数组
   -  以每一个下标作为第一个节点，用双指针遍历节点后面的元素。
   - 如果  nums[i]>0 说明当前节点以及后面的节点都不能满足要求
   - 如果当前节点和前面一个节点相同，跳过当前接节点，因为题目要求结果不能相同
     -  nums[i]+nums[L]+nums[R]==nums[i]+nums[L]+nums[R]，加入结果。判断左界和右界是否和下一位置重复，将指针移动到不重复的位置。
     - 如果和大于0，右指针左移
     - 如果和小于0，左指针右移

```java
public List<List<Integer>> threeSum(int[] nums) {
 List<List<Integer>> res= new ArrayList<>();
           Arrays.sort(nums);
           for(int i=0;i<nums.length;i++){
                int j=i+1,k=nums.length-1;
                if(nums[i]>0) break;
                if(i>=1&&nums[i]==nums[i-1]) continue;
                while(j<k){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        res.add(list);
                        while(j<k&&nums[j+1]==nums[j])j++;
                        while(j<k&&nums[k]==nums[k-1]) k--;
                        j++;
                        k--;
                    }
                    else if(nums[j]+nums[k]+nums[i]>0)k--;
                    else if(nums[i]+nums[j]+nums[k]<0) j++;
                }  
           }
           return res;
    }
```

