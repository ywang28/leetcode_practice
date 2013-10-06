public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)  return;
        root.next = null;
        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        queue.add(null);
        // last null node can be left in the queue
        while(queue.size() > 1)  {
            TreeLinkNode current = queue.poll();
            current.next = queue.peek();
            if(current.left != null)  {
                queue.add(current.left);
                queue.add(current.right);
                if(queue.peek() == null)  {
                    queue.poll();
                    queue.add(null);
                }
            }
        }    
    }
}
