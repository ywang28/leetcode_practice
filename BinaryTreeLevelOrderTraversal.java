public class BinaryTreeLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(root == null)  return ret;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        ArrayList<Integer> level = new ArrayList<Integer>();
        // last elem in q is null, which implicates end of traversal
        while(q.size() > 1)  {
            TreeNode curr = q.poll();
            // one level is complete
            if(curr == null)  {
                q.add(null);
                ret.add(level);
                level = new ArrayList<Integer>();
            }
            else  {
                level.add(curr.val);
                if(curr.left != null)  q.add(curr.left);
                if(curr.right != null)  q.add(curr.right);
            }
            
        }
        // add last level
        ret.add(level);
        return ret;
    }
    public ArrayList<ArrayList<Integer>> levelOrder2nd(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(root==null)  return ret;
        LinkedList<TreeNode>  queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        ArrayList<Integer> level = new ArrayList<Integer>();
        // last null will remain in the queue
        while(queue.size()!=1)  {
            TreeNode curr = queue.poll();
            // one level is finished
            if(curr == null)  {
                ret.add(level);
                level = new ArrayList<Integer>();
                queue.add(null);
            }
            else  {
                level.add(curr.val);
                if(curr.left!=null)  {
                    queue.add(curr.left);
                }
                if(curr.right!=null)  {
                    queue.add(curr.right);
                }
            }
        }
        // last level
        ret.add(level);
        return ret;
    }
}
