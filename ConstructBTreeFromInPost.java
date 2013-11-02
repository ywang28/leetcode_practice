public class ConstructBTreeFromInPost {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(inorder==null || postorder==null)  return null;
        if(inorder.length!=postorder.length)  return null;
        if(inorder.length==0)  return null;
        return buildTreeHelper(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode buildTreeHelper(int[] inorder, int start1, int end1, int[] postorder, int start2, int end2)  {
        // if left or right child is null, return null
        if(start1>end1)  return null;
        TreeNode root = new TreeNode(postorder[end2]);
        int root_index = findIndex(inorder,root.val);
        if(root_index == -1)  return null;
        // right sub tree length
        int rlength = end1 - root_index;
        root.left = buildTreeHelper(inorder,start1,root_index-1,postorder,start2,end2-rlength-1);
        root.right = buildTreeHelper(inorder,root_index+1,end1,postorder,end2-rlength,end2-1);
        return root;
    }
    public int findIndex(int[] inorder, int val)  {
        for(int i=0; i<inorder.length; i++)  {
            if(inorder[i] == val)  return i;
        }
        return -1;
    }
}
