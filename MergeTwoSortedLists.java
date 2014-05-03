public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)  return l2;
        if(l2==null)  return l1;
        ListNode dummy = new ListNode(0), curr = dummy, tmp;
        while(l1 != null && l2 != null)  {
            if(l1.val < l2.val)  {
                tmp = l1;
                l1 = l1.next;
                curr.next = tmp;
            }
            else  {
                tmp = l2;
                l2 = l2.next;
                curr.next = tmp;
            }
            curr = curr.next;
        }
        curr.next = (l1 == null) ? l2 : l1;
        return dummy.next;
    }
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1==null)  return l2;
        if(l2==null)  return l1;
        ListNode dummy = new ListNode(0), curr = dummy;
        while(l1!=null && l2!=null)  {
            if(l1.val < l2.val)  {
                curr.next = l1;
                l1 = l1.next;
            }
            else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1==null) ? l2 : l1;
        return dummy.next;
    }
}
