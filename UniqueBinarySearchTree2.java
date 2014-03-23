public class UniqueBinarySearchTree2 {
    public ArrayList<TreeNode> generateTrees(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return genHelper(1, n);
    }
    public ArrayList<TreeNode> genHelper(int start, int end)  {
        ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
        if(start>end)  {
            ret.add(null);
            return ret;
        }
        // pick one of them as root and recursively generate trees
        for(int i=start; i<=end; i++)  {
            ArrayList<TreeNode> left = genHelper(start, i-1);
            ArrayList<TreeNode> right = genHelper(i+1, end);
            for(TreeNode leftNode : left)  {
                for(TreeNode rightNode : right)  {
                    TreeNode rt = new TreeNode(i);
                    rt.left = leftNode;
                    rt.right = rightNode;
                    ret.add(rt);
                }
            }
        }
        return ret;
    }
}
