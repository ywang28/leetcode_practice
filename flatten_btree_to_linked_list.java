public class Solution {
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        flattenHelper(root);
    }
    public TreeNode flattenHelper(TreeNode root)  {
        if(root==null)  return null;
        if(root.left==null && root.right==null)  return root;
        TreeNode leftTail = flattenHelper(root.left);
        TreeNode rightTail = flattenHelper(root.right);
        // if left subtree is not empty, insert between root and right subtree
        if(leftTail != null)  {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return (rightTail==null) ? leftTail : rightTail;
    }
}