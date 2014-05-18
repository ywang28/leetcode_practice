public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        if(root == null)  return;
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        inOrder(root, nodes);
        TreeNode first = null, last = null;
        for(int i=0; i<nodes.size()-1; i++)  {
            // record first and last number in reverse order
            if(nodes.get(i).val > nodes.get(i+1).val)  {
                if(first==null)  {
                    first = nodes.get(i);
                }
                last = nodes.get(i+1);
            }
        }
        // swap values
        if(first != null && last != null)  {
            int tmp = first.val;
            first.val = last.val;
            last.val = tmp;
        }
    }
    public void inOrder(TreeNode root, ArrayList<TreeNode> nodes)  {
        if(root == null)  return;
        inOrder(root.left, nodes);
        nodes.add(root);
        inOrder(root.right, nodes);
    }
    TreeNode prev, curr, first, last;
    public void recoverTree2nd(TreeNode root) {
        if(root == null || (root.left==null && root.right==null))  return;
        first = null;
        last = null;
        prev = null;
        curr = null;
        inorder(root);
        if(first!=null && last!=null)  {
            int tmp = first.val;
            first.val = last.val;
            last.val = tmp;
        }
    }
    private void inorder(TreeNode root)  {
        if(root==null)  return;
        inorder(root.left);
        curr = root;
        if(prev!=null && prev.val > curr.val)  {
            if(first==null)  {
                first = prev;
            }
            last = curr;
        }
        prev = curr;
        inorder(root.right);
    }
}
