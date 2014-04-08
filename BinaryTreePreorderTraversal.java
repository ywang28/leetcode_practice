public class BinaryTreePreorderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(root==null)  return ret;
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        while(!st.isEmpty())  {
            TreeNode curr = st.pop();
            ret.add(curr.val);
            if(curr.right!=null)  {
                st.push(curr.right);
            }
            if(curr.left!=null)  {
                st.push(curr.left);
            }
        }
        return ret;
    }
}
