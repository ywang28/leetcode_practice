public class SumRootToLeafNumbers  {
    int sum = 0;
    public int sumNumbers(TreeNode root)  {
        if(root==null)  return 0;
        if(root.left==null && root.right==null)  return root.val;
        sum = 0;
        int curr = 0;;
        sumHelper(root, curr);
        return sum;
    }
    public void sumHelper(TreeNode root, int curr)  {
        curr = curr * 10 + root.val;
        if(root.left==null && root.right==null)  {
            sum += curr;
            return;
        }
        if(root.left!=null)  sumHelper(root.left, curr);
        if(root.right!=null)  sumHelper(root.right, curr);
    }
}
