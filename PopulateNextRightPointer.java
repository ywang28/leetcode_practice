public class PopulateNextRightPointer {
    public void connect(TreeLinkNode root) {
        if(root==null)  return;
        root.next = null;
        TreeLinkNode leftWall = root;
        TreeLinkNode parent, pre, curr, next;
        while(leftWall!=null)  {
            parent = leftWall;
            pre = null;
            while(parent.left==null && parent.right==null && parent.next!=null)  {
                parent = parent.next;
            }
            // find left wall for next level
            leftWall = (parent.left==null) ? parent.right : parent.left;
            while(parent!=null)  {
                if(parent.left==null && parent.right==null)  {
                    parent = parent.next;
                    continue;
                }
                // with both kids. link them
                if(parent.left!=null && parent.right!=null)  {
                    parent.left.next = parent.right;
                    curr = parent.left;
                    next = parent.right;
                }
                // pick the only kid
                else  {
                    curr = (parent.left==null) ? parent.right : parent.left;
                    next = curr;
                }
                // link previous kid with current kid
                if(pre!=null)  {
                    pre.next = curr;
                }
                pre = next;
                parent = parent.next;
            }
            // link end of each level to null
            if(pre!=null)  {
                pre.next = null;
            }
        }
    }
}
