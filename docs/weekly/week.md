## 已解决题目列表

| 周赛 | 题目编号 | 题名                       | 难度   | 题解 |
| ---- | -------- | -------------------------- | ------ | ---- |
| 213  | 1640     | 能否连接形成数组           | easy   |      |
| 214  | 1646     | 获取生成数组中的最大值     | easy   |      |
| 241  | 1647     | 字符频次唯一的最小删除次数 | middle |      |
| 215  | 5601     | 设计有序流                 | easy   |      |
| 215  | 5603     | 确定两个字符串是否接近     | middle |      |

## week 213

### 1640. 能否连接形成数组



```java
public boolean canFormArray(int[] arr, int[][] pieces) {
        for(int j=0;j<pieces.length;j++){
            int index=0;
            int len=pieces[j].length;
            int flag=0;
            for(int k=0;k<arr.length;k++){
                if(flag==1&&arr[k]!=pieces[j][index]) return false;
                if(arr[k]==pieces[j][index]){
                    index++;
                    flag=1;
                    if(index==len)  break;
                }

            }
            if(index!=len) return false;
        }
        return true;
    }
```

## week214

### 1646. 获取生成数组中的最大值

```java
 public int getMaximumGenerated(int n) {
      if(n==0) return 0;
      int a[]= new int[n+1];
      a[0]=0;
      a[1]=1;
      for(int i=1;i<=n;i++){
         if(i*2>=2&&i*2<=n)  a[i*2]=a[i];
         if((i*2+1)>=2&&(i*2+1)<=n){
          a[2*i + 1] = a[i] + a[i + 1];
        }
      }
    int max=0;
    for(int i=0;i<a.length;i++){
      if(a[i]>max){
        max=a[i];
      }
    }
       return max;
    }
```

### 1647. 字符频次唯一的最小删除次数

解法一  ：最初的解法，这个解法太辣鸡了，代码简直辣眼睛

```java
 //第一次 百分之五六十
    public int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
                return (e1.getValue()).compareTo(e2.getValue());
            }
        });
        Map<Character, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        int times=0;
        System.out.println(map);
        for (Character a:
                result.keySet()) {
            Integer re=map.get(a);
            map.put(a,map.get(a)+1);
            while(map.containsValue(re)){
                System.out.println(re);
                int newval= re-1;
                re=newval;
                times++;
                if(newval==0) break;

            }
            map.put(a,re);
        }
        return times;
    }
```

解法二

```java
 //第二次 双百
    public int minDeletions2(String s) {
        int  a[]= new int[26];
        for(int i=0;i<s.length();i++){
            a[s.charAt(i)-'a']++;
        }
        Arrays.sort(a);
        Set<Integer> set= new HashSet();
        int times=0;
        for(int i=0;i<a.length;i++){
            int k=0;
            while(a[i]!=0&&set.add(a[i])==false){
                k++;
                a[i]--;
            }
            times+=k;
        }
        return times;
    }
```

## week215

### 1656. 设计有序流

```

```

