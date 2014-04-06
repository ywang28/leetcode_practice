public class ReorderList {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null)  return;
        ListNode slow = head, fast = head;
        // find the half point of list
        while(fast!=null && fast.next!=null)  {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next, curr = head;
        slow.next = null;
        mid = reverseList(mid);
        // merge 2 lists
        while(mid!=null)  {
            ListNode tmp = curr.next, tmp2 = mid.next;
            curr.next = mid;
            mid.next = tmp;
            curr = tmp;
            mid = tmp2;
        }
    }
    public ListNode reverseList(ListNode mid)  {
        if(mid==null || mid.next==null)  return mid;
        ListNode prev = mid, curr = mid.next, next;
        while(curr!=null)  {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        mid.next = null;
        return prev;
    }
}
