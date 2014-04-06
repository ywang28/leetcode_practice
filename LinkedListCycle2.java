public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head==null || head.next==null)  return null;
        if(head.next == head)  return head;
        ListNode slow = head, fast = head, search = head;
        while(fast!=null && fast.next!=null)  {
            slow = slow.next;
            fast = fast.next.next;
            // circle found
            if(fast == slow)  break;
        }
        // no circle found
        if(fast==null || fast.next==null)  return null;
        // when slow reaches start of loop, fast is k steps into loop. Say loop size is size
        // when fast meets slow, slow is into loop size-k steps.
        // If move search and slow one step each time, they should meet at start of loop
        while(search != slow)  {
            search = search.next;
            slow = slow.next;
        }
        return search;
    }
}
