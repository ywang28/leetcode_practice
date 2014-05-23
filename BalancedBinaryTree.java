/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BalanceNode  {
    boolean isBalanced;
    int height;
    BalanceNode(boolean b, int n)  {
        isBalanced = b;
        height = n;
    }
}
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return balanceHelper(root).isBalanced;
    }
    public BalanceNode balanceHelper(TreeNode root)  {
        if(root==null)  return new BalanceNode(true, 0);
        BalanceNode left = balanceHelper(root.left);
        BalanceNode right = balanceHelper(root.right);
        boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) < 2;
        int height = Math.max(left.height, right.height) + 1;
        return new BalanceNode(isBalanced, height);
    }
    public boolean isBalanced2nd(TreeNode root) {
        return balanceHelper(root) > -1;
    }
    public int balanceHelper(TreeNode root)  {
        if(root == null)  return 0;
        int left = balanceHelper(root.left), right = balanceHelper(root.right);
        return (left == -1 || right == -1 || Math.abs(left - right) > 1) ? -1 : Math.max(left, right) + 1;
    }
}
