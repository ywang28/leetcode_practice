public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] num) {
        if(num==null || num.length==0)  return null;
        return convert(num, 0, num.length-1);
    }
    public TreeNode convert(int[] num, int start, int end)  {
        if(start > end)  return null;
        int mid = start + (end-start)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = convert(num, start, mid-1);
        root.right = convert(num, mid+1, end);
        return root;
    }
}
