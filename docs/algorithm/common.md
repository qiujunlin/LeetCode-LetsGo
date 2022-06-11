二叉树非递归：

前序：



```
    public List<Integer> preorderTraversal(TreeNode root) {
        
        Stack<TreeNode> stack =new Stack();
        TreeNode cur =root;
        ArrayList<Integer> res =new ArrayList();
        if(root!=null)
        stack.push(root);
        while(!stack.isEmpty()){
           TreeNode n = stack.pop();
           res.add(n.val);
           if(n.left!=null){
               stack.push(n.left);
           }
           if(n.right!=null){
               stack.push(n.right);
           }
        }
        return res;
    
    }
```

后序：

```
    public List<Integer> postorderTraversal(TreeNode root) {
        
        Stack<TreeNode> stack =new Stack();
        TreeNode cur =root;
        ArrayList<Integer> res =new ArrayList();
        if(root!=null)
        stack.push(root);
        while(!stack.isEmpty()){
           TreeNode n = stack.pop();
           res.add(n.val);
           if(n.left!=null){
               stack.push(n.left);
           }
           if(n.right!=null){
               stack.push(n.right);
           }
        }
        Collections.reverse(res);
        return res;
        
    }
```

中序：

```
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s =new Stack();
        TreeNode cur =root;
        List<Integer> res= new ArrayList();
        while(cur!=null||!s.isEmpty()){
            if(cur!=null){
                s.push(cur);
                cur=cur.left;
            }else{
                cur = s.pop();
                res.add(cur.val);
                cur=cur.right;
            }

        }
        return res;
    }
```

