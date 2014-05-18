public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        // Note: The ValidBST object is instantiated only once and is reused by each test case.
        if(root==null)  return true;
        ArrayList<Integer> nodes = new ArrayList<Integer>();
        return inOrder(root,nodes);
    }
    public boolean inOrder(TreeNode root, ArrayList<Integer> nodes)  {
        if(root==null)  return true;
        boolean isLeftValid = inOrder(root.left,nodes);
        if(!isLeftValid)  return false;
        if(nodes.size()>0 && nodes.get(nodes.size()-1)>=root.val)  return false;
        nodes.add(root.val);
        boolean isRightValid = inOrder(root.right,nodes);
        if(!isRightValid)  return false;
        return true;
    }
    public boolean isValidBST2nd(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<TreeNode> inorder = new ArrayList<TreeNode>();
        inorderTraversal(root, inorder);
        for(int i=0; i<inorder.size()-1; i++)  {
            if(inorder.get(i).val >= inorder.get(i+1).val)  return false;
        }
        return true;
    }
    public void inorderTraversal(TreeNode root, ArrayList<TreeNode> inorder)  {
        if(root == null)  return;
        inorderTraversal(root.left, inorder);
        inorder.add(root);
        inorderTraversal(root.right, inorder);
    }
}
