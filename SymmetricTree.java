public class SymmetricTree {
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
    public boolean isSymmetric2nd(TreeNode root) {
        if(root==null)  return true;
        return isMirror(root.left, root.right);
    }
    public boolean isMirror(TreeNode left, TreeNode right)  {
        if(left==null || right==null)  return left == right;
        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
