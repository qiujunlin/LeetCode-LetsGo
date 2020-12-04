package Tree;

public class ConvertSortedArraytoBinarySearchTree108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(0,nums.length-1,nums);
    }
    TreeNode dfs(int left,int right,int nums[]){
        if(left>right) return null;

        int mid=(right+left)/2;
        TreeNode node =new TreeNode(nums[mid]);
        node.left=dfs(left,mid-1,nums);
        node.right=dfs(mid+1,right,nums);
        return node;
    }
}
