/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null || node.neighbors==null)  return null;
        // map from original node to cloned node
        HashMap<UndirectedGraphNode,UndirectedGraphNode> cloned = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        return cloneGraphHelper(node, cloned);
    }
    public UndirectedGraphNode cloneGraphHelper(UndirectedGraphNode node, HashMap<UndirectedGraphNode,UndirectedGraphNode> cloned)  {
        if(cloned.containsKey(node))  {
            return cloned.get(node);
        }
        else  {
            UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
            cloned.put(node,newNode);
            for(UndirectedGraphNode n : node.neighbors)  {
                newNode.neighbors.add(cloneGraphHelper(n,cloned));
            }
            return newNode;
        }
    }
}
