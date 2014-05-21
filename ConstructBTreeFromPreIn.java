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
    public TreeNode buildTree2nd(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length==0 || inorder==null || inorder.length==0 || preorder.length!=inorder.length)  return null;
        return buildHelper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    private TreeNode buildHelper(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2)  {
        if(s1 < 0 || e1 > preorder.length-1 || s1 > e1)  return null;
        TreeNode root = new TreeNode(preorder[s1]);
        int rootInorder = s2;
        // find root location in inorder
        for(; rootInorder <= e2; rootInorder++)  {
            if(inorder[rootInorder] == preorder[s1])  {
                break;
            }
        }
        root.left = buildHelper(preorder, s1 + 1, s1 + rootInorder - s2, inorder, s2, rootInorder - 1);
        root.right = buildHelper(preorder, s1 + rootInorder - s2 + 1, e1, inorder, rootInorder + 1, e2);
        return root;
    }
}
