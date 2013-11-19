public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if(head==null || head.next==null || n==0)  return head;
        ListNode slow = head, fast = head;
        // explore n steps ahead. If fast meets end, wrap arround
        for(int i=0; i<n; i++)  {
            fast = (fast.next == null) ? head : fast.next;
        }
        // rotate steps is same with list size
        if(fast == head)  return head;
        // move slow and fast together to the end
        while(fast.next != null)  {
            fast = fast.next;
            slow = slow.next;
        }
        // link new list
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}
