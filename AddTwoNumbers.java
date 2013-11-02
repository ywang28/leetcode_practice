public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(l1==null)  return l2;
        if(l2==null)  return l1;
        ListNode res = new ListNode(0);
        ListNode current = res;
        int carry = 0;
        while(l1!=null && l2!=null)  {
            ListNode sum = new ListNode((l1.val+l2.val+carry)%10);
            carry = (l1.val+l2.val+carry)/10;
            current.next = sum;
            current = sum;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode nextnode = (l1==null) ? l2 : l1;
        while(nextnode!=null && carry==1)  {
            ListNode remaining = new ListNode((nextnode.val+carry)%10);
            carry = (nextnode.val+carry)/10;
            current.next = remaining;
            current = remaining;
            nextnode = nextnode.next;
        }
        if(nextnode==null)  {
            if(carry==1)  {
                current.next = new ListNode(1);
            }
        }
        else  {
            current.next = nextnode;
        }
        return res.next;
    }
}
