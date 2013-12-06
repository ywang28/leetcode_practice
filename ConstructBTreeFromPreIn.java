public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null || preorder.length != inorder.length)  return null;
        return buildTreeHelper(preorder, 0, inorder, 0, inorder.length);
    }
    public TreeNode buildTreeHelper(int[] preorder, int s1, int[] inorder, int s2, int len)  {
        if(len < 1)  return null;
        TreeNode root = new TreeNode(preorder[s1]);
        // find root index in inorder array
        int rootIndex = s2;
        for(rootIndex = s2; rootIndex < s2+len; rootIndex++)  {
            if(inorder[rootIndex] == root.val)  {
                break;
            }
        }
        // left subtree length
        int leftLen = rootIndex-s2;
        int rightLen = len-leftLen-1;
        root.left = buildTreeHelper(preorder, s1+1, inorder, s2, leftLen);
        root.right = buildTreeHelper(preorder, s1+leftLen+1, inorder, rootIndex+1, rightLen);
        return root;
    }
}
