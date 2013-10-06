public class Solution {
    int max;
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)  return 0;
        max = root.val;
        int currentmax = maxPathHelper(root);
        return (max>currentmax) ? max : currentmax;
    }
    public int maxPathHelper(TreeNode root)  {
        if(root==null)  return 0;
        int leftmax = maxPathHelper(root.left);
        int rightmax = maxPathHelper(root.right);
        max = Math.max(root.val+leftmax+rightmax,max);
        max = Math.max(root.val+leftmax,max);
        max = Math.max(root.val+rightmax,max);
        return Math.max(Math.max(leftmax,rightmax)+root.val,root.val);
    }
}
