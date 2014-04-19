public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null)  return null;
        if(head.next==null)  return head;
        ListNode parent = head;
        ListNode current = head.next;
        ListNode next;
        ListNode ret = current;
        while(current.next!=null)  {
            next = current.next;
            current.next = parent;
            // If odd number of nodes, next.next may be null
            current = (next.next==null) ? next : next.next;
            parent.next = current;
            parent = next;
        }
        // If not odd number of nodes, reverse the last pair
        if(parent!=current)  {
            current.next = parent;
            // Remember to end the list!
            parent.next = null;
        }
        return ret;
    }
    public ListNode swapPairs2(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head==null || head.next==null)  return head;
        ListNode dummy = new ListNode(0), prev = dummy, first = head, second, next;
        dummy.next = head;
        while(first!=null && first.next!=null)  {
            second = first.next;
            next = second.next;
            prev.next = second;
            second.next = first;
            first.next = next;
            prev = first;
            first = next;
        }
        return dummy.next;
    }
}
