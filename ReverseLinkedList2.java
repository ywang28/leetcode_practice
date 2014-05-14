public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || head.next==null || m==n)  return head;
        ListNode dummy = new ListNode(0), pre = dummy, curr = head, begin = dummy;
        dummy.next = head;
        for(int i = 1; i <= n; i++)  {
            // record node before reversion
            if(i == m)  {
                begin = pre;
            }
            // find first place to reverse
            if(i <= m)  {
                pre = pre.next;
                curr = curr.next;
            }
            else {
                ListNode tmp = curr.next;
                curr.next = pre;
                pre = curr;
                curr = tmp;
            }
        }
        // link reversed list to original list
        begin.next.next = curr;
        begin.next = pre;
        return dummy.next;
    }
    public ListNode reverseBetween2nd(ListNode head, int m, int n) {
        if(head==null || head.next==null || m==n)  return head;
        ListNode dummy = new ListNode(0), start = dummy, end, prev = dummy, curr = head, next = head.next;
        dummy.next = head;
        int cnt = 1;
        // find start position
        for(; cnt<m; cnt++)  {
            start = start.next;
        }
        end = start.next;
        prev = start.next;
        curr = prev.next;
        next = curr.next;
        while(cnt<n)  {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(curr!=null)  {
                next = curr.next;
            }
            cnt++;
        }
        start.next = prev;
        end.next = curr;
        return dummy.next;
    }
}
