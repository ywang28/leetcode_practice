public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null)  return head;
        ListNode out = head.next, parent = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(out!=null)  {
            ListNode start = dummy;
            ListNode tmp = out;
            while(start.next!=out && start.next.val < out.val)  {
                start = start.next;
            }
            // partial sort is already in correct order
            if(start.next==out)  {
                parent = parent.next;
            }
            // insertion needed
            else  {
                parent.next = out.next;
                out.next = start.next;
                start.next = out;
            }
            // go to next node node
            out = parent.next;
        }
        return dummy.next;
    }
}
