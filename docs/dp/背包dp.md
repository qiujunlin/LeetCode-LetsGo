



背包

01 背包 “

二维，正向枚举。且   $j<w_i$  时候，直接等于 $dp[i-1][j]$,  当 $j>=w_i$时候，就是下面
$$
dp[i][j] =max\left\{dp[i-1][j],dp[i-1][j-w_i]+v_i\right\}
$$
一维,逆向枚举，枚举的范围为$w_i -> amount$
$$
dp[i] =max\left\{ dp[i],dp[j-w_i]+v_i\right\}
$$

如果使用一维逆向枚举的话，一般都是外循环nums。内循环是len。每次内循环之前需要将dp[I]值为0 





完全背包 ,

一维

正向枚举，范围为 $(w_i,amount)$
$$
dp[j] = max\left\{dp[j],dp[j-w_i]+v_i\right\}
$$
二维 ，正向枚举 
$$
dp[i][j] = maxx\left\{dp[i-1][j],dp[i][j-w_i]+v_i\right\}
$$


二维

```
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        n = len(coins)
        dp = [[amount+1] * (amount+1) for _ in range(n+1)]    # 初始化为一个较大的值，如 +inf 或 amount+1
        # 合法的初始化
        dp[0][0] = 0    # 其他 dp[0][j]均不合法
        
        # 完全背包：优化后的状态转移
        for i in range(1, n+1):             # 第一层循环：遍历硬币
            for j in range(amount+1):       # 第二层循环：遍历背包
                if j < coins[i-1]:          # 容量有限，无法选择第i种硬币
                    dp[i][j] = dp[i-1][j]
                else:                       # 可选择第i种硬币
                    dp[i][j] = min( dp[i-1][j], dp[i][j-coins[i-1]] + 1 )

        ans = dp[n][amount] 
        return ans if ans != amount+1 else -1

```

求排列 外循环是 1- len，求组合 外循环是nums
