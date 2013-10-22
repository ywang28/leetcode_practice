public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k<2)  return head;
        ListNode end = findEnd(head,k);
        // result list head
        ListNode finalHead = end;
        // 3 pointers to reverse list
        ListNode p = head;
        ListNode m,q,nextHead;
        while(end!=null)  {
            nextHead = end.next;
            m = p.next;
            q = m.next;
            // reverse list within group
            while(p!=end)  {
                m.next = p;
                p = m;
                m = q;
                if(q!=null)  {
                    q = q.next;
                }
            }
            p = nextHead;
            // end of next group
            end = findEnd(p,k);
            // if next group needs reversal, link to end of next group
            // else link to begin of next group
            head.next = (end==null) ? p : end;
            head = p;
        }
        return (finalHead==null) ? head : finalHead;
    }
    // find end of next group
    public ListNode findEnd(ListNode start, int k)  {
        while(start!=null && k>1)  {
            start = start.next;
            k--;
        }
        return start;
    }
}
