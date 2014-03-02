// wrong answer
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)  return head;
        ListNode dummy = new ListNode(0), end=head;
        dummy.next = head;
        // find the last node
        while(end.next!=null)  end = end.next;
        quickSort(dummy, end);
        return dummy.next;
    }
    public void quickSort(ListNode start, ListNode end)  {
        if(start.next == end)  return;
        ListNode pivot = start.next, pos = pivot, curr = pivot;
        while(curr != end)  {
            if(curr.next.val < pivot.val)  {
                int tmp = curr.val;
                curr.val = pos.next.val;
                pos.next.val = tmp;
                pos = pos.next;
            }
            curr = curr.next;
        }
        // swap pivot
        int tmp = pos.next.val;
        pos.next.val = pivot.val;
        pivot.val = tmp;
        // recursively sort
        quickSort(start, pos);
        quickSort(pos.next, end);
    }
}
