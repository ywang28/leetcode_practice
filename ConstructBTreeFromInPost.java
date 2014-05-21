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
    public TreeNode builder(int[] inorder, int s1, int e1, int[] postorder, int s2, int e2)  {
        if(s1>e1 || s2>e2)  return null;
        TreeNode root = new TreeNode(postorder[e2]);
        // find out left tree length
        int len;
        for(len=0; len<=e1-s1; len++)  {
            if(inorder[s1+len]==root.val)  break;
        }
        root.left = builder(inorder, s1, s1+len-1, postorder, s2, s2+len-1);
        root.right = builder(inorder, s1+len+1, e1, postorder, s2+len, e2-1);
        return root;
    }
    public TreeNode buildTree3rd(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length)  return null;
        return buildHelper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    private TreeNode buildHelper(int[] inorder, int s1, int e1, int[] postorder, int s2, int e2)  {
        if(s1 < 0 || e1 > inorder.length - 1 || s1 > e1)  return null;
        int rootIndex = 0, rootVal = postorder[e2];
        TreeNode root = new TreeNode(rootVal);
        for(; rootIndex <= e1; rootIndex++)  {
            if(inorder[rootIndex] == rootVal)  break;
        }
        root.left = buildHelper(inorder, s1, rootIndex - 1, postorder, s2, s2 + rootIndex - s1 - 1);
        root.right = buildHelper(inorder, rootIndex + 1, e1, postorder, s2 + rootIndex - s1, e2 - 1);
        return root;
    }
}
