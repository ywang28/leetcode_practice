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
    public List<Integer> postorderTraversal2nd(TreeNode root) {
        ArrayList<Integer>  ret = new ArrayList<Integer>();
           if (root == null)  return ret;
        Stack<TreeNode> st = new Stack<TreeNode>();
        Stack<TreeNode> st2 = new Stack<TreeNode>();
st.push(root);
        while (!st.isEmpty())  {
            TreeNode curr = st.pop();
            st2.push(curr);
            if (curr.left != null)   st.push(curr.left);
            if (curr.right != null)   st.push(curr.right);
        }
        while(!st2.isEmpty())  {
            ret.add(st2.pop().val);
        }
        return ret;
    }
}
