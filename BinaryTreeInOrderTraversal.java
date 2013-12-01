public class BinaryTreeInOrderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(root == null)  return ret;
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        nodes.push(root);
        boolean leftVisited = false;
        while(!nodes.isEmpty())  {
            TreeNode curr = nodes.peek();
            if(!leftVisited && curr.left != null)  {
                nodes.push(curr.left);
            }
            else  {
                ret.add(curr.val);
                nodes.pop();
                if(curr.right != null)  {
                    nodes.push(curr.right);
                    leftVisited = false;
                }
                else  {
                    leftVisited = true;
                }
            }
        }
        return ret;
    }
}
