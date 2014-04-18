public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy, ahead = dummy;
        // find nth node ahead
        for(int i=0; i<=n; i++)  {
            ahead = ahead.next;
        }
        // move 2 pointers together
        while(ahead != null)  {
            ahead = ahead.next;
            curr = curr.next;
        }
        // remove node
        curr.next = curr.next.next;
        return dummy.next;
    }
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0), slow = dummy, fast = dummy;
        dummy.next = head;
        while(fast.next!=null && n>0)  {
            fast = fast.next;
            n--;
        }
        while(fast.next!=null)  {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
