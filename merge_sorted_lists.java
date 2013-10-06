public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(l1==null)  return l2;
        if(l2==null)  return l1;
        // tmp keeps link to next node when updating links
        ListNode tmp;
        ListNode smaller;
        ListNode bigger;
        if(l1.val<l2.val)  {
            smaller = l1;
            bigger = l2;
        }
        else  {
            smaller = l2;
            bigger = l1;            
        }
        ListNode head = smaller;
        while(bigger!=null)  {
            while(smaller.next!=null && smaller.next.val<=bigger.val)  {
                smaller = smaller.next;
            }
            tmp = smaller.next;
            smaller.next = bigger;
            bigger = tmp;
        }
        return head;
    }
}
