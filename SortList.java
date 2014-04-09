public class SortList {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)  return head;
        // cut the list into halves and sort separately
        ListNode mid = findMid(head);
        ListNode left = sortList(head), right = sortList(mid);
        // merge the generated list
        ListNode curr = new ListNode(0), dummy = curr;
        while(left!=null && right!=null)  {
            if(left.val < right.val) {
                curr.next = left;
                left = left.next;
            }
            else  {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        curr.next = (left==null) ? right : left;
        return dummy.next;
    }
    public ListNode findMid(ListNode head)  {
        ListNode prev = new ListNode(0), slow = head, fast = head;
        while(fast!=null && fast.next!=null)  {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // cut off the prev half list
        prev.next = null;
        return slow;
    }
}
