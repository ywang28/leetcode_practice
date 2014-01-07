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
    public ListNode addTwoNumbers2nd(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        ListNode dummy = new ListNode(0), curr = dummy;
        int carry = 0;
        
        while(l1!=null || l2!=null)  {
            int val1=0, val2=0;
            if(l1!=null)  {
                val1 = l1.val;
                l1 = l1.next;
            }
            if(l2!=null)  {
                val2 = l2.val;
                l2 = l2.next;
            }
            int sum = val1 + val2 + carry;
            curr.next = new ListNode(sum%10);
            carry = sum/10;
            curr = curr.next;
        }
        
        // last carry
        if(carry>0)  {
            curr.next = new ListNode(carry);
            curr = curr.next;
        }
        curr.next = null;
        
        return dummy.next;
    }
}
