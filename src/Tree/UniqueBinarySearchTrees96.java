package Tree;

public class UniqueBinarySearchTrees96 {

        public int numTrees(int n) {
            int res[]= new int[n+1];
            res[0]=1;
            res[1]=1;
            for(int i=2;i<=n;i++){
                for(int j=1;j<=i;j++){
                    res[i]+=res[j-1]*res[i-j];
                }
            }
            return res[n];
        }

    //解法2 使用 递归

    public int numTrees2(int n){
        if(n==1||n==0){
            return 1;
        }
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=numTrees(i-1)*numTrees(n-i);
        }
        return sum;
    }
}
