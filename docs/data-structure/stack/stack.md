## 20 有效的括号

使用栈 

```java
 public boolean isValid(String s) {
        char ch[] = s.toCharArray();
       Stack<Character> stack = new Stack();
       for(char c: ch){
         if(stack.isEmpty()) stack.push(c);
         else if(c==']'&&stack.peek()=='['){
           stack.pop();
         }else if(c==')'&&stack.peek()=='('){
             stack.pop();
         }else if(c=='}'&&stack.peek()=='{'){
              stack.pop();
         }else {
           stack.push(c);
         }
       }
       return stack.size()==0;
    }
```

