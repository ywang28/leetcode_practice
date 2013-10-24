public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists==null || lists.size()==0)  return null;
        if(lists.size()==1)  return lists.get(0);
        ListNode head = lists.get(0);
        ListNode p, q, tmp, pre;
        // connect lists one by one
        for(int i=1; i<lists.size(); i++)  {
            if(head==null)  {
                head = lists.get(i);
                continue;
            }
            if(lists.get(i)==null)  continue;
            p = head;
            pre = new ListNode(0);
            pre.next = p;
            q = lists.get(i);
            // pick smaller value as head
            if(q.val < p.val)  head = q;
            // p points to smaller node, and q points to larger node
            while(q!=null)  {
                // find next connection point
                while(p!=null && p.val <= q.val)  {
                    pre = p;
                    p = p.next;
                }
                // connect lists and reassign p to smaller node
                pre.next = q;
                tmp = p;
                p = q;
                q = tmp;
            }
        }
        return head;
    }
}
