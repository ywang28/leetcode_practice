public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)  return head;
        ListNode curr = head, fast = curr.next;
        while(fast != null)  {
            if(fast.val == curr.val)  {
                fast = fast.next;
            }
            else  {
                curr.next = fast;
                curr = fast;
                fast = fast.next;
            }
        }
        // link last node to null
        curr.next = fast;
        return head;
    }
}
