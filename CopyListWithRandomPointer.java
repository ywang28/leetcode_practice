public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode,RandomListNode> nodemap = new HashMap<RandomListNode,RandomListNode>();
        return copyListHelper(head, nodemap);
    }
    public RandomListNode copyListHelper(RandomListNode head, HashMap<RandomListNode,RandomListNode> nodemap)  {
        if(head==null)  return null;
        if(nodemap.containsKey(head))  return nodemap.get(head);
        RandomListNode ret = new RandomListNode(head.label);
        nodemap.put(head,ret);
        ret.next = copyListHelper(head.next, nodemap);
        ret.random = copyListHelper(head.random,nodemap);
        return ret;
    }
    public RandomListNode copyRandomList2nd(RandomListNode head) {
        if( head == null )   return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        return copyListHelper(head, map);        
    }
    private RandomListNode copyListHelper2nd(RandomListNode head, HashMap<RandomListNode, RandomListNode> map)  {
        if( head == null )  return null;
        if(map.containsKey(head))  return map.get(head);
        RandomListNode newNode = new RandomListNode(head.label);
        map.put(head, newNode);
        newNode.next = copyListHelper2nd(head.next, map);
        newNode.random = copyListHelper2nd(head.random, map);
        return newNode;
    }
}
