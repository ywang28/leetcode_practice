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
}
