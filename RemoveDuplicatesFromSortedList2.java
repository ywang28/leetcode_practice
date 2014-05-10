public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)  return head;
        ListNode dummy = new ListNode(0), slow = head, fast = head.next, curr = dummy;
        dummy.next = head;
        boolean dup = false;
        while(fast != null)  {
            if(fast.val == slow.val)  {
                dup = true;
            }
            else  {
                // remove duplicates
                if(dup)  {
                    curr.next = fast;
                    slow = fast;
                }
                else  {
                    curr = slow;
                    slow = slow.next;
                }
                dup = false;
            }
            fast = fast.next;
        }
        // remove last duplicates
        if(slow.next != null)  curr.next = null;
        return dummy.next;
    }
    public ListNode deleteDuplicates2(ListNode head) {
        if(head==null || head.next==null)  return head;
        ListNode dummy = new ListNode(0), prev = dummy, slow = head, fast = head;
        dummy.next = head;
        while(fast!=null)  {
            while(fast!=null && fast.val==slow.val)  {
                fast = fast.next;
            }
            // duplicates found
            if(fast!=slow.next)  {
                prev.next = fast;
            }
            else  {
                prev = slow;
            }
            slow = fast;
        }
        return dummy.next;
    }
}
