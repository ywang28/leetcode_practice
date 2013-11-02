public class ZigZagLevelOrder {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root);
        while(true)  {
            if(s1.isEmpty() && s2.isEmpty())  break;
            ArrayList<Integer> traversal1 = new ArrayList<Integer>();
            ArrayList<Integer> traversal2 = new ArrayList<Integer>();
            while(!s1.isEmpty())  {
                TreeNode node1 = s1.pop();
                traversal1.add(node1.val);
                if(node1.left!=null)  s2.push(node1.left);
                if(node1.right!=null)  s2.push(node1.right);
            }
            while(!s2.isEmpty())  {
                TreeNode node2 = s2.pop();
                traversal2.add(node2.val);
                if(node2.right!=null)  s1.push(node2.right);
                if(node2.left!=null)  s1.push(node2.left);
            }
            if(!traversal1.isEmpty())    res.add(traversal1);
            if(!traversal2.isEmpty())    res.add(traversal2);
            
        }
        return res;
    }
}
