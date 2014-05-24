public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)  return false;
        if(root.left==null && root.right==null)  return root.val==sum;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
    public boolean hasPathSum2nd(TreeNode root, int sum) {
        if(root == null)  return false;
        if(root.left == null && root.right == null)  return root.val == sum;
        if(hasPathSum(root.left, sum - root.val))  return true;
        return hasPathSum(root.right, sum - root.val);
    }
}
