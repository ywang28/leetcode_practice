public class Solution {
    public int minDepth(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(root==null)  return 0;
        if(root.left==null)  return minDepth(root.right)+1;
        if(root.right==null)  return minDepth(root.left)+1;
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}
