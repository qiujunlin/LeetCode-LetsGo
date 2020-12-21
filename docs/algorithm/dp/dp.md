## 已解决题目列表



| 题目 | 名称     | 解法   | 难度   |
| ---- | -------- | ------ | ------ |
| 1    | 两数之和 | hash   | easy   |
| 15   | 三数之和 | 双指针 | middle |
|      |          |        |        |

## 53 最大子序和

## 62 不同路径

## 63 不同路径II

## 64 最小路径和



## 70 爬楼梯



转移方程： 
$$
dp[I]=dp[i-1]+dp[i-2]
$$


```Java
 public int climbStairs(int n) {
        int dp[]= new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
```

## 120 三角形的最小路径和

## 121 买股票的最佳时机



## 139 单词拆分

## 174 地下城游戏

### 解法一：Dp

[官方题解不错](https://leetcode-cn.com/problems/dungeon-game/solution/di-xia-cheng-you-xi-by-leetcode-solution/)

```JAVA 
  public int calculateMinimumHP(int[][] dungeon) {
      int m = dungeon[0].length;//kuan
      int n = dungeon.length;//gao
      int dp[][]= new int[n][m];
      dp[n-1][m-1]=Math.max(1-dungeon[n-1][m-1],1);
      for(int i=n-2;i>=0;i--)  dp[i][m-1]=Math.max(dp[i+1][m-1]-dungeon[i][m-1],1);
      for(int i=m-2;i>=0;i--) dp[n-1][i]=Math.max(dp[n-1][i+1]-dungeon[n-1][i],1);
      for(int i=n-2;i>=0;i--){
          for(int j=m-2;j>=0;j--){       
          dp[i][j]=Math.min(Math.max(dp[i+1][j]-dungeon[i][j],1),Math.max(dp[i][j+1]-dungeon[i][j],1));
          }
      }
      return dp[0][0];
    }
```

### 解法二 ：DFS

[甜姨的解法不错](https://leetcode-cn.com/problems/dungeon-game/solution/jian-dan-dfskan-yi-yan-jiu-ming-bai-e-by-sweetiee/)

最近崇尚这种极简写法  不错 

```
    public int calculateMinimumHP(int[][] dungeon) {
          return dfs(dungeon,0,0,dungeon.length,dungeon[0].length,new int[dungeon.length][dungeon[0].length]);
    }
    int dfs(int[][] dungeon,int i,int j,int m,int n,int[][] dp){
      if(i==m-1&&j==n-1) return Math.max(1-dungeon[i][j],1);
      if(dp[i][j]!=0) return dp[i][j];
      if(i==m-1)  return Math.max(dfs(dungeon,i,j+1,m,n,dp)-dungeon[i][j],1);
      if(j==n-1)  return Math.max(dfs(dungeon,i+1,j,m,n,dp)-dungeon[i][j],1);
      int num = Math.max(Math.min(dfs(dungeon,i,j+1,m,n,dp),dfs(dungeon,i+1,j,m,n,dp))-dungeon[i][j],1);
      return dp[i][j]=num;
    }
```



## 198 打家劫色

## 213 打家劫舍II

## 279 完全平方数目

[题解](https://leetcode-cn.com/problems/perfect-squares/solution/hua-jie-suan-fa-279-wan-quan-ping-fang-shu-by-guan/)

```java
public int numSquares(int n) {
       int dp[]= new int[n+1];
       dp[1]=1;
       for(int i=2;i<=n;i++){
         dp[i]=i;
         for(int j=0;i-j*j>=0;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
         }
       } 
       return dp[n];
    }
```



## 300 最长上升子序列

### 方法一 动态规划

[题解](https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/)

这道题用 动态规划居然只超过了百分之5    这么慢

```java
public int lengthOfLIS(int[] nums) {
        int dp[]= new int[nums.length+1];
        dp[0]=1;
        int max=1;
        for(int  i=1;i<nums.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]) {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(dp[i],max);
        }
        return max;
    }
```

### 解法二 二分查找



## 322 零钱兑换

### 解法1 贪心 + dfs，解题思路

[参考](https://leetcode-cn.com/problems/coin-change/solution/javadi-gui-ji-yi-hua-sou-suo-dong-tai-gui-hua-by-s/)

1. 不断的使用最大的硬币，这样获得的硬币的数量是最少的。使用乘法进行加速

2. 最先找到 的解并不一定的最优解，有可能不是最优解。因此我们需要把所有的情况递归完

3. 减枝，在循环的时候进行一个次数的判断，可以进行减枝。

   代码

   ```java
   int min=Integer.MAX_VALUE;
       public int coinChange3(int[] coins, int amount) {
           //先进行排序，由大到小进行遍历
           Arrays.sort(coins);
           //count  数量  idnex：下标
           dfs(coins,amount,0,coins.length-1);
           return min==Integer.MAX_VALUE?-1:min;
       }
       void dfs(int[] coins,int amount,int count,int index){
           if(amount<0) return;//小于0表示 溢出  直接返回
           if(amount==0) { //等于0 表示 刚好分配完全 这个时候要和最小值的结果进行一个比较
               min=Math.min(min,count);
               return;
           }
           if(index==-1) return; //如果下标 越界  直接返回
           //k=0  表示 不使用当前的零钱，进行下一个零钱的遍历
           //  k+count  是一个剪纸  如果 k+count  小于最后的结果 继续遍历，如果大于的话，继续遍历也就没有了必要
           for(int k=amount/coins[index];k>=0&&k+count<min;k--){
               //这里注意是index-1 不是index--
               dfs(coins,amount-k*coins[index],count+k,index-1);
           }
   
   ```

   

### 解法二 记忆化搜索

在使用递归的时候，由于有很多节点会进行重复操作，用一个额外的数组来保存之前搜索的结果

[参考](https://leetcode-cn.com/problems/coin-change/solution/322-by-ikaruga/)

```java
 int dp[];
    public int coinChange(int[] coins, int amount) {
        dp=new int[amount+1];
        return dfs(coins,amount);
        //return [amount];
    }
    int dfs(int []coins,int amount){
        //返回条件
        if(amount==0) return 0;
        if(amount<0) return -1;
     //如果 不为0  直接返回值  就 不用继续递归了
       if(dp[amount]!=0) return dp[amount];
        int  min=Integer.MAX_VALUE;
        //  遍历数组中的每一个  得到最小值
        for(int a:coins){
            int res=dfs(coins,amount-a);
            if(res==-1) continue;
            min=Math.min(min,res+1);
        }
        //如果最终的最小值改变了 就改变dp数组中的值
        dp[amount]=min==Integer.MAX_VALUE?-1:min;
        return dp[amount];
    }
```

### 解法三 动态规划

[参考](https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/)

则 F(i)F(i) 对应的转移方程应为

![1607054648101](C:\Users\Acer\AppData\Roaming\Typora\typora-user-images\1607054648101.png)

```java
public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            int res=amount+1;
            for(int j=0;j<coins.length;j++) {
                if (i >= coins[j]) {
                    int a = dp[i - coins[j]];
                    if (a != amount + 1 && res > a) res = a + 1;
                }
            }
            dp[i]=res==amount+1?amount+1:res;
        }

        return dp[amount]==amount+1?-1:dp[amount];
        //return dfs(coins,dp,amount);
    }
```

参考：

## 零钱兑换II

动态规划 

这道题太难理解了，我觉得我好笨啊，理解得很模糊，，没有很明白，等后面再看一遍再来写一下题解

```Java
public int change(int amount, int[] coins) {
       int dp[][]= new int[coins.length+1][amount+1];
       for(int i=0;i<=coins.length;i++){
           dp[i][0]=1;
       }
       for(int i=1;i<=coins.length;i++){
           for(int j=1;j<=amount;j++){
               if(j>=coins[i-1]){
                 dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
               }else{
                 dp[i][j]=dp[i-1][j];
               }
           }
       }
       return dp[coins.length][amount];
    }
   
```

## 509. 斐波那契数

### 解法一 暴力递归  

复杂度太高，进行了大量的重复计算

```java
public int fib(int N) {
        if(N==1) return 1;
        if(N==0) return 0;
        else return fib(N-1)+fib(N-2);
    }
```

## 746. 使用最小花费爬楼梯



状态转移方程是：

`dp[i] = min(dp[i-2], dp[i-1]) + cost[i]`

```Java
    public int minCostClimbingStairs(int[] cost) {
         int  dp[] = new int[cost.length];
         dp[0]=cost[0];
         dp[1]=cost[1];
         for(int i=2;i<cost.length;i++){
             dp[i]=Math.min(dp[i-1],dp[i-2])+cost[i];
         }
         return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }
```

### 解法二   记忆化递归（带备忘录的递归）

备忘录方法：每次算出某个子问题的答案后别急着返回，先记到「备忘录」里再返回；每次遇到一个子问题先去「备忘录」里查一查，如果发现之前已经解决过这个问题了，直接把答案拿出来用，不要再耗时去计算了。

```Java
 public int fib(int N) {
          int dp[]=new int[N+1];
          return fun(N,dp);
    }
    int  fun(int N,int[] dp){
        if(N==0) return 0;
        if(N==1) return 1;
        if(dp[N]!=0) return dp[N];
        dp[N]=fun(N-1,dp)+fun(N-2,dp);
        return dp[N];
    }
```

### 解法三 动态规划

解法一和解法二的结合就是动态规划，由下到上

转移方程, 这里可以使用双指针进行优化
$$
dp[i]=dp[i-1]+dp[i-2]
$$

```java
    public int fib(int N) {
        if(N==0) return 0;
         int dp[]= new int[N+1];
         dp[0]=0; dp[1]=1;
         for(int i=2;i<=N;i++){
         dp[i]=dp[i-1]+dp[i-2];
         }
         return dp[N];
    }
```

