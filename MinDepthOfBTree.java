public class MinDepthOfBTree {
    public int minDepth(TreeNode root) {
        // Note: The MinDepthOfBTree object is instantiated only once and is reused by each test case.
        if(root==null)  return 0;
        if(root.left==null)  return minDepth(root.right)+1;
        if(root.right==null)  return minDepth(root.left)+1;
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
    public int minDepth2nd(TreeNode root) {
        if(root == null)  return 0;
        int left = minDepth(root.left), right = minDepth(root.right);
        return (left == 0) ? right + 1 : ((right == 0) ? left + 1 : Math.min(left, right) + 1);
    }
}
