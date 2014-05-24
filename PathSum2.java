public class PathSum2 {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(root==null)  return ret;
        pathSumHelper(root, sum, ret, new ArrayList<Integer>());
        return ret;
    }
    public void pathSumHelper(TreeNode root, int sum, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> path)   {
        if(root==null)  return;
        if(root.left==null && root.right==null)  {
            if(sum==root.val) {
                path.add(root.val);
                ret.add(new ArrayList<Integer>(path));
                path.remove(path.size()-1);
            }
            return;
        }
        // DFS search
        path.add(root.val);
        pathSumHelper(root.left, sum-root.val, ret, path);
        pathSumHelper(root.right, sum-root.val, ret, path);
        path.remove(path.size()-1);
    }
    public ArrayList<ArrayList<Integer>> pathSum2nd(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        pathHelper(root, sum, ret, new ArrayList<Integer>());
        return ret;
    }
    public void pathHelper(TreeNode root, int sum, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> path)  {
        if(root == null)  return;
        if(root.left == null && root.right == null)  {
            if(sum == root.val)  {
                path.add(root.val);
                ret.add(new ArrayList<Integer>(path));
                path.remove(path.size()-1);
            }
            return;
        }
        path.add(root.val);
        pathHelper(root.left, sum - root.val, ret, path);
        pathHelper(root.right, sum - root.val, ret, path);
        path.remove(path.size()-1);
    }
}
