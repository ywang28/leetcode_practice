public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy, ahead = dummy;
        // fine nth node ahead
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
}
