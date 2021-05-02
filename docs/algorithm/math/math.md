## 已解决题目列表

## 进制转换：

### n>n 万能方法:

```
BigInteger bigint=new BigInteger(hexs, 16);//hexs  :String 类型数据
int numb=bigint.toString(hexs));
```

### 10->n 万能 

```
Integer.toString(num,hexs); 
```

### N->10 万能

```
Integer.parseInt("1001",2)
```

### n->2   

```
1.取余法

2.使用移位操作

3.Integer.toBinaryString(n);
```

### 10->8

```
Integer.toOctalString(int i)   //返回i的八进制的字符串表示
```

### 10>16

```
Integer.toHexString(i)
```



### 16->2 

```
map
```



### 16->8

```
1. 16->2 and 2->10
2. 16->10 and 10->2 
```



## ##7. 整数反转

这道题有个要求 就是不能用long型去存储

思路就是每次循环 都判断是否越界  以及 下次是否 越界 排除法

```java
  public int reverse(int x) {
       int res = 0;
       while(x!=0){
         int temp = x%10;
         if(res>Integer.MAX_VALUE/10||(res*10==Integer.MAX_VALUE&&temp>7)){
           return 0;
         }
         if(res<Integer.MIN_VALUE/10||(res*10==Integer.MIN_VALUE&&temp<-8)){
          return 0;
         }
         x=x/10;
         res=res*10+temp;
       }  
    
    return res;
    }
```



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

