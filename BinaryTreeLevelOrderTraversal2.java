public class BinaryTreeLevelOrderTraversal2 {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(root == null)  return ret;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty())  {
            // flag for end of each level
            queue.add(null);
            ArrayList<Integer> list = new ArrayList<Integer>();
            TreeNode curr = queue.poll();
            while(curr != null)  {
                list.add(curr.val);
                if(curr.left != null)  {
                    queue.add(curr.left);
                }
                if(curr.right != null)  {
                    queue.add(curr.right);
                }
                curr = queue.poll();
            }
            ret.add(0, curr);
        }
        return ret;
    }
}
