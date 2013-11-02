public class ConvertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null) return null;
        ArrayList<Integer> listnodes = new ArrayList<Integer>();
        while(head!=null)  {
            listnodes.add(head.val);
            head = head.next;
        }
        return buildBST(listnodes,0,listnodes.size()-1);
    }
    public TreeNode buildBST(ArrayList<Integer> nodes, int start, int end)  {
        if(start>end)  return null;
        int mid = (start+end)/2;
        TreeNode newnode = new TreeNode(nodes.get(mid));
        newnode.left = buildBST(nodes,start,mid-1);
        newnode.right = buildBST(nodes,mid+1,end);
        return newnode;
    }
}
