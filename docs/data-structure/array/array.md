## 已解决题目列表



| 题目 | 名称     | 解法   | 难度   |
| ---- | -------- | ------ | ------ |
| 1    | 两数之和 | hash   | easy   |
| 15   | 三数之和 | 双指针 | middle |
|      |          |        |        |



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

## 119杨辉三角2

跟上面一题差不多吧  思路可以使用二维数组  最好使用一纬数组，因为节省空间



```java
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list  = new ArrayList();
        int  a[] = new int[rowIndex+1];
        for(int i  = 0; i<=rowIndex; i++){
          //if(i==0||i==1) a[i][0]
          for(int j=i;j>=0;j--){
            if(j == i ||j ==0) a[j]=1;
            else a[j]=a[j]+a[j-1];
          }
        }
        for(int i=0;i<rowIndex+1;i++){
          list.add(a[i]);
        }
        return list;
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

## 6.Z字变换

使用一个标志flag 来标志遍历的方向

```java
public String convert(String s, int numRows) {
      if(numRows==1) return s;
       List<StringBuilder> list = new ArrayList();
       for(int i =0;i<numRows;i++){
         list.add(new StringBuilder());
       }
       char ch[] =  s.toCharArray();
       int flag =1;
       int index =-1 ;
       for(char  c : ch){
          index =index+flag;
          list.get(index).append(c);
          if(index==numRows-1){
              flag =-1;
          }else if(index ==0){
              flag =1;
          }
       }
       StringBuilder res = new StringBuilder();
       for(StringBuilder st :list){
            res.append(st);
       }
        return res.toString();
     }
```

