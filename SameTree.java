public class isSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)  return true;
        if(p==null || q==null)  return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public boolean isSameTree2nd(TreeNode p, TreeNode q) {
        if(p==null && q==null)  return true;
        if(p==null || q==null)  return false;
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
