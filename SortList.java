public class SortList {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)  return head;
        // cut the list into halves and sort separately
        ListNode mid = findMid(head);
        ListNode left = sortList(head), right = sortList(mid);
        // merge the generated list
        ListNode curr = new ListNode(0), dummy = curr;
        while(left!=null && right!=null)  {
            if(left.val < right.val) {
                curr.next = left;
                left = left.next;
            }
            else  {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        curr.next = (left==null) ? right : left;
        return dummy.next;
    }
    public ListNode findMid(ListNode head)  {
        ListNode prev = new ListNode(0), slow = head, fast = head;
        while(fast!=null && fast.next!=null)  {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // cut off the prev half list
        prev.next = null;
        return slow;
    }
    public ListNode sortList2nd(ListNode head) {
           if (head == null || head.next == null)  return head;
        // more than one node
        // find the mid point of the list. parent is parent to the slow pointer
        ListNode dummy = new ListNode(0), slow = dummy, fast = head;
        dummy.next = head;
        // edge case:  1 -> 2 -> null
        // after loop, slow is parent to mid point
        while (fast != null && fast.next != null)  {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode leftHead = sortList(head), rightHead = sortList(mid);
        return mergeList(leftHead, rightHead);        
    }
    private ListNode mergeList(ListNode left, ListNode right)  {
        // deal with edge case
        if (left == null)   return right;
        if (right == null)   return left;
        // go through list and merge
        ListNode dummy = new ListNode(0), mergeHead = dummy;
        while (left != null && right != null)  {
            if (left.val < right.val)  {
                dummy.next = left;
                left = left.next;
            }
            else  {
                dummy.next = right;
                right = right.next;
            }
            dummy = dummy.next;
        }
        dummy.next = (left == null) ? right : left;
        return mergeHead.next;
    }
}
