public class BinaryTreePostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(root==null)  return ret;
        Stack<TreeNode> pre = new Stack<TreeNode>(), post = new Stack<TreeNode>();
        pre.push(root);
        // get pre order into post
        while(!pre.isEmpty())  {
            TreeNode curr = pre.pop();
            if(curr.left!=null)  {
                pre.push(curr.left);
            }
            if(curr.right!=null)  {
                pre.push(curr.right);
            }
            post.push(curr);
        }
        // reverse of pre is post
        while(!post.isEmpty())  {
            ret.add(post.pop().val);
        }
        return ret;
    }
}
    
