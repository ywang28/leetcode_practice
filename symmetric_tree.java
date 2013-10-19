public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)  return true;
        return isSymmetricHelper(root.left,root.right);
    }
    public boolean isSymmetricHelper(TreeNode leftnode, TreeNode rightnode)  {
        if(leftnode==null && rightnode==null)  return true;
        if(leftnode==null || rightnode==null)  return false;
        if(!isSymmetricHelper(leftnode.left,rightnode.right))  return false;
        if(leftnode.val!=rightnode.val)  return false;
        return isSymmetricHelper(leftnode.right,rightnode.left);
    }
}
