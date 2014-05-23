public class ConvertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null) return null;
        ArrayList<Integer> listnodes = new ArrayList<Integer>();
        while(head!=null)  {
            listnodes.add(head.val);
            head = head.next;
        }
        return buildBST(listnodes,0,listnodes.size()-1);
    }
    public TreeNode buildBST(ArrayList<Integer> nodes, int start, int end)  {
        if(start>end)  return null;
        int mid = (start+end)/2;
        TreeNode newnode = new TreeNode(nodes.get(mid));
        newnode.left = buildBST(nodes,start,mid-1);
        newnode.right = buildBST(nodes,mid+1,end);
        return newnode;
    }
    public TreeNode sortedListToBST2(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head==null)  return null;
        if(head.next==null)  return new TreeNode(head.val);
        ListNode prev=head, slow=head, fast=head;
        // get the middle point as root position
        while(fast!=null && fast.next!=null)  {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // break up left sublist
        prev.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST2(head);
        root.right = sortedListToBST2(slow.next);
        return root;
    }
    public TreeNode sortedListToBST3rd(ListNode head) {
        if(head == null)  return null;
        if(head.next == null)  return new TreeNode(head.val);
        ListNode slow = head, fast = head.next.next;
        // slow will be parent to root node
        while(fast != null && fast.next != null)  {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.next.val);
        ListNode right = slow.next.next;
        slow.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(right);
        return root;
    }
}
