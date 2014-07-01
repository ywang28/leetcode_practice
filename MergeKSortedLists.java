public class MergeKSortedLists {
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
    public ListNode mergeKLists2(ArrayList<ListNode> lists) {
        if(lists==null || lists.size()==0)  return null;
        if(lists.size()==1)  return lists.get(0);
        // merge sort
        int size = lists.size(), end = size-1, mid;
        while(end > 0)  {
            mid = end/2;
            for(int i=0; i<=mid; i++)  {
                merge(lists, i, end-i);
            }
            end = mid;
        }
        return lists.get(0);
    }
    // merge start and end lists in start list
    public void merge(ArrayList<ListNode> lists, int start, int end)  {
        if(start==end)  return;
        ListNode dummy = new ListNode(0), curr = dummy, l1 = lists.get(start), l2 = lists.get(end);
        while(l1!=null && l2!=null)  {
            if(l1.val<l2.val)  {
                curr.next = l1;
                l1 = l1.next;
            }
            else  {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1==null)  ? l2 : l1;
        lists.set(start, dummy.next);
    }
    public ListNode mergeKLists3rd(List<ListNode> lists) {
        if (lists == null || lists.size() == 0)  return null;
        Comparator<ListNode> comp = new Comparator<ListNode>()  {
            @Override
            public int compare(ListNode l1, ListNode l2)  {
                if (l1.val < l2.val)  return -1;
                if (l1.val == l2.val)  return 0;
                return 1;
            }
        };
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(),comp);
        for (ListNode node : lists)  {
            if (node != null)  {
                queue.add(node);
            }
        }
        ListNode head = new ListNode(0), dummy = head;
        while (!queue.isEmpty())  {
            head.next = queue.poll();
            head = head.next;
            if (head.next != null)  {
                queue.add(head.next);
            }
        }
        return dummy.next;
    }
}
