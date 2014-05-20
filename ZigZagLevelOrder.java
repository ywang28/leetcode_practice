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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder2nd(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(root==null)  return ret;
        Stack<TreeNode> parent = new Stack<TreeNode>(), curr = new Stack<TreeNode>();
        parent.push(root);
        // print from left to right
        boolean toRight = false;
        while(!parent.isEmpty())  {
            ArrayList<Integer> level = new ArrayList<Integer>();
            while(!parent.isEmpty())  {
                TreeNode node = parent.pop();
                if(node==null)  continue;
                level.add(node.val);
                if(toRight)  {
                    curr.push(node.right);
                    curr.push(node.left);
                }
                else  {
                    curr.push(node.left);
                    curr.push(node.right);
                }
            }
            if(level.size()>0)  ret.add(level);
            Stack<TreeNode> tmp = parent;
            parent = curr;
            curr = tmp;
            toRight = !toRight;
        }
        return ret;
    }
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder3rd(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(root==null)  return ret;
        Stack<TreeNode> upper = new Stack<TreeNode>(), lower = new Stack<TreeNode>();
        boolean leftToRight = true;
        upper.push(root);
        while(!upper.isEmpty())  {
            ArrayList<Integer>  curr = new ArrayList<Integer>();
            while(!upper.isEmpty())  {
                TreeNode node = upper.pop();
                curr.add(node.val);
                if(leftToRight)  {
                    if(node.left!=null)  {
                        lower.push(node.left);
                    }
                    if(node.right!=null)  {
                        lower.push(node.right);
                    }
                }
                else  {
                    if(node.right!=null)  {
                        lower.push(node.right);
                    }
                    if(node.left!=null)  {
                        lower.push(node.left);
                    }
                }
            }
            ret.add(curr);
            Stack<TreeNode> tmp = upper;
            upper = lower;
            lower = tmp;
            leftToRight = !leftToRight;
        }
        return ret;
    }
}
