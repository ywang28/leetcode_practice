public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head==null || head.next==null)  return false;
        ListNode fast = head, slow = head;
        while(fast!=null && fast.next!=null)  {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)  return true;
        }
        return false;
    }
}
