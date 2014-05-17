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
    public ArrayList<TreeNode> generateTrees2(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return generateTrees2nd(1, n);
    }
    public ArrayList<TreeNode> generateTrees2nd(int start, int end)  {
        ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
        if(start>end)  {
            ret.add(null);
            return ret;
        }
        for(int i=start; i<=end; i++)  {
            ArrayList<TreeNode> leftNodes = generateTrees2nd(start,i-1);
            ArrayList<TreeNode> rightNodes = generateTrees2nd(i+1,end);
            for(TreeNode left : leftNodes)  {
                for(TreeNode right : rightNodes)  {
                    TreeNode curr = new TreeNode(i);
                    curr.left = left;
                    curr.right = right;
                    ret.add(curr);
                }
            }
        }
        return ret;
    }
}
