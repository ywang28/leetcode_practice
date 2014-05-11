public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null)  return head;
        ListNode smallHead = new ListNode(0), largeHead = new ListNode(0), small = smallHead, large = largeHead, curr = head;
        while(curr != null)  {
            // belong to small group
            if(curr.val < x)  {
                small.next = curr;
                small = curr;
            }
            else  {
                large.next = curr;
                large = curr;
            }
            curr = curr.next;
        }
        // if either list is empty, return original list
        if(largeHead.next == null || smallHead.next == null)  {
            return head;
        }
        // link 2 sublists together
        else  {
            small.next = largeHead.next;
            large.next = null;
            return smallHead.next;
        }
    }
    public ListNode partition2(ListNode head, int x) {
        if(head==null || head.next==null)  return head;
        ListNode small = new ListNode(0), large = new ListNode(0), smallHead = small, largeHead = large, curr = head;
        while(curr!=null)  {
            if(curr.val < x)  {
                small.next = curr;
                small = curr;
            }
            else  {
                large.next = curr;
                large = curr;
            }
            curr = curr.next;
        }
        // link together
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
