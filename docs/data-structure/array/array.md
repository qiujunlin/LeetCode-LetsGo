## 已解决题目列表



| 题目 | 名称     | 解法   | 难度   |
| ---- | -------- | ------ | ------ |
| 1    | 两数之和 | hash   | easy   |
| 15   | 三数之和 | 双指针 | middle |
|      |          |        |        |

## 1.两数之和



### 解法一 时间复杂度O(n^2)



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



### 解法二  时间	O(1)

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

## 48 旋转图像

很有意思的一道题，需要自己去对坐标进行慢慢的分析。

### 解法一 原地旋转

```java
 public void rotate(int[][] matrix) {
        int m=matrix.length;
         for(int i=0;i<(m+1)/2;i++){
           for(int j=0;j<m/2;j++){
               int temp = matrix[i][j];
               matrix[i][j]=matrix[m-j-1][i];//(0,1),(2,0)
               matrix[m-j-1][i]=matrix[m-i-1][m-j-1];//(2,0).(3,2)
               matrix[m-i-1][m-j-1]=matrix[j][m-i-1]; 
               matrix[j][m-i-1]=temp;//（0,1）,(1,3),(0,2),(2,3),(1,2),(2,2)
           }
         }

    }
```

### 解法二  翻转



翻转的方法其实就是利用了矩阵的性质，先对矩阵进行左下   右上   的交换，然后进行水平翻转。

代码以后再写

## 31 下一个排列

技巧题目  这个解析特别清楚

[这个](https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/)

综合思路就是 ：见注解

```java
   public void nextPermutation(int[] nums) {
//步骤1. 从后往前寻找第一个升序的连个节点
     int low =0;int high=0;
    for(int i = nums.length-2 ;i>=0 ; i-- ){
        if(nums[i]<nums[i+1]){
             low = i;
             high=i+1;
             break;
        }
    }
     int uper=-1;
 //步骤2：寻找第一个大于low的数字，这里可以使用二分查找
    for(int i=nums.length-1;i>=high;i--){
        if(nums[i]>nums[low]){
            uper=i;
            break;
        }
    }
    //步骤3：交换顺序
    if(left!=-1){
    int temp=nums[low];
    nums[low]= nums[left];
    nums[left] = temp;
     }
    //步骤4: 对后面的结果进行排序排序
    Arrays.sort(nums,high,nums.length);
     }
```





## 118. 杨辉三角

没什么说的,金典题目，有点动态规划的意思。好像也不算

代码：

```java
 public List<List<Integer>> generate(int numRows) {
        int nums[][]= new int[numRows+1][numRows+1];
        List<List<Integer>> res = new ArrayList();   
        for(int i=1;i<=numRows;i++){
            List<Integer> list = new ArrayList();
            for(int j=1;j<=i;j++){
               if(j==1||j==i) nums[i][j]=1;
               else
               nums[i][j]=nums[i-1][j-1]+nums[i-1][j];
               list.add(nums[i][j]);
            }
            res.add(list);
        }
        return res;
    }
```

## 189  旋转数组

## 解法一  暴力

暴力算法 就是一次移动一个，将最后一个变量保存 ，然后将前面length-1个数向后移动，在吧刚刚保存的数字放在第一位。循环K次  就成功了。

​     是原地算法  不难  

```java 
 public void rotate(int[] nums, int k) {
        for(int i=1;i<=k;i++){
            int temp=nums[nums.length-1];
            int j=0;
            for( j=nums.length-1;j>0;j--){
                nums[j]=nums[j-1];
            }
            nums[j]=temp;
        
    }

```

### 解法二 使用额外数组

这个方法 其实就是遍历一遍 把所有的数字放在他该在的位置上。不过需要另外开辟一个数组，使用了额外的空间。

```java 
 public void rotate(int[] nums, int k) {
       int a[] = new int[nums.length];
       for(int i=0;i<nums.length;i++){
           a[i]=nums[i];
       }
       for(int i=0;i<nums.length;i++){
              nums[(i+k)%(nums.length)]=a[i];
       }
    }
```

### 解法三  原地交换

这个应该算是一种技巧性的方法。

* 先翻转整个数组
* 翻转前k个数
* 翻转后面**nums,length-k**个数 

```java
 public void rotate(int[] nums, int k) {
           k=k%nums.length;
           reverse(nums,0,nums.length-1);
           reverse(nums,0,k-1);
           reverse(nums,k,nums.length-1);

    }
    void reverse(int nums[],int left ,int right){
        while(left<right){
            int temp =  nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
```

#### 解法四   