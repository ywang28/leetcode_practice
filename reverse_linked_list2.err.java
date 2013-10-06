public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null)  return null;
        if(m==n)  return head;
        int cnt = 1;
        while(cnt++<m-1)  {
            head = head.next;
        }
        ListNode end = (m==1) ? null : head;
        ListNode first = (m==1) ? head : head.next;
        ListNode mid = first.next;
        ListNode last = mid.next;
        ListNode start;
        while(cnt++<n-1)  {
            mid.next = first;
            first = mid;
            mid = last;
            last = (last==null) ? null : last.next; 
        }
        start = (last==null) ? first : mid;
        
        
    }
}
