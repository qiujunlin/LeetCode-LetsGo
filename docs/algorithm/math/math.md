## 已解决题目列表



| 题目 | 名称     | 解法   | 难度   |
| ---- | -------- | ------ | ------ |
| 1    | 两数之和 | hash   | easy   |
| 15   | 三数之和 | 双指针 | middle |
|      |          |        |        |



## 1.1 50. Pow(x, n)

这道题需要注意的地方是有个测试用例为**-2147483648**，如果将他转为正数的话，会丢失精度，int 的取值范围为 -2^31至2^31-1 (-2147483648 ~ 2147483647)，因此必须用一个long来保存N，才不会丢失。背住这道题。

#### 方法一：快速幂

```java

double quickMul(double x, long long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }

    double myPow(double x, int n) {
        long long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }


```

方法2： 调用库函数，pow是一个本地方法 

```java
    public double myPow(double x, int n) {
           long a=n;
          return a>=0?Math.pow(x,a):(1.0/Math.pow(x,-a));
    }
```

