## 已解决题目列表



| 场次 | 题目编号 | 题名           | 难度   | 题解 |
| ---- | -------- | -------------- | ------ | ---- |
| 38   | 5550     | 踩炸弹         | middle |      |
| 40   | 5557     | 最大重复字符串 |        |      |
| 40   | 5558     | 合并两个链表   |        |      |
| 40   | 5560     | 设计前中后队列 |        |      |



## 40场

### 5557. 最大重复子字符串

##### 第一次解法 太菜

```java
 public int maxRepeating(String sequence, String word) {
        int len=word.length();
        int res=0;
        for(int i=0;i<sequence.length();i++){
              if(sequence.charAt(i)==word.charAt(0)){
                  int num=0;
                  while(i<sequence.length()&&i+len<=sequence.length()&&sequence.substring(i,i+len).equals(word)){
                      num++;
                      i=i+len;
                  }
                  res=Math.max(num,res);
              }
             
          }
        return res;
    }
```

第二次：String为我们提供了API，可以判断字符串中是否包含另一个字符串，所以我们只要使用他们就可以，在这里我使用的是indexOf

```java
  public int maxRepeating(String sequence, String word) {
        int num = 0;
        String temp = word;
        while (sequence.indexOf(temp) >= 0) {
            num++;
            temp += word;
        }
        return num;
    }
```

### 5558. 合并两个链表

```java
public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode res=list1;
        
        ListNode first=null,second=null;
        int num=0;
       // int pre=list1;
        
        while(list1!=null){
            num++;
             if(num==a){
                 first=list1;
             }    
            if(num-2==b){
                second=list1;
            }
            list1=list1.next;
            
        }
        first.next=list2;
    ListNode l2=list2;
        while(list2.next!=null){
            list2=list2.next;
        }
        list2.next=second;
        return res;
    }
```

### 5560. 设计前中后队列

```java
LinkedList<Integer>  list;
    public FrontMiddleBackQueue() {
         list = new LinkedList();
    }
    
    public void pushFront(int val) {
          list.addFirst(val);
    }
    
    public void pushMiddle(int val) {
          int index=list.size();
           list.add(index/2,val);
    }
    
    public void pushBack(int val) {
         list.addLast(val);
    }
    
    public int popFront() {
        if(list.size()==0) return -1;
        int res=list.getFirst(); 
        list.removeFirst();
        return res;
    }
    
    public int popMiddle() {
        if(list.size()==0) return -1;
        int res=0;
        if(list.size()%2==0){
     res= list.get(list.size()/2-1);
     list.remove(list.size()/2-1);}else{
             res=list.get(list.size()/2);
            list.remove(list.size()/2);
        }
        return res;
    }
    
    public int popBack() {
        if(list.size()==0) return -1;
         int res=list.getLast();
        list.removeLast();
        return res;
    }
```

## 1671. 得到山形数组的最少删除次数

思路：dp

进行两次最长上升子序列的做法，然后结合起来，就变成这道题的答案了，。

```java
 public int minimumMountainRemovals(int[] nums) {
        int ldp[]=lengthOfLIS1(nums);
        int rdp[]=lengthOfLIS2(nums);
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(ldp[i]>1&&rdp[i]>1)
            res=Math.max(ldp[i]+rdp[i]-1,res);
        }
        return nums.length-res;
    }
    public int[] lengthOfLIS1(int[] nums) {
        int dp[]= new int[nums.length];
        for(int  i=0;i<nums.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]) {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp;
    }
    public int[] lengthOfLIS2(int[] nums) {
        int dp[]= new int[nums.length];
        for(int  i=nums.length-1;i>=0;i--){
            dp[i]=1;
            for(int j=nums.length-1;j>i;j--){
                if(nums[j]<nums[i]) {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp;
    }
```

