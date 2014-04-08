// wrong answer
public class LRUCache {
    class CacheNode  {
        int value;
        CacheNode prev;
        CacheNode next;
        CacheNode (int val)  {
            value = val;
            prev = null;
            next = null;
        }
    }
    // last records last used node
    private CacheNode last = null;
    private int capacity;
    private HashMap<Integer,CacheNode> map;
    LRUCache (int cap)  {
        capacity = cap;
        map = new HashMap<Integer,CacheNode>();
    }
    public int get(int key)  {
        if(map.containsKey(key))  {
            return map.get(key).value;
        }
        last = map.get(key);
        return -1;
    }
    public void set(int key, int value)  {
        if(map.containsKey(key))  {
            map.get(key).value = value;
            last = map.get(key);
        }
        else {
            // cache is full
            if(capacity==0) {
                CacheNode trace = last;
                // found oldest node and remove
                while(trace.prev!=null)  {
                    trace = trace.prev;
                }
                map.remove(trace);
                if(trace.next!=null)  {
                    trace.next.prev = null;
                }
                capacity++;
            }
            CacheNode node = new CacheNode(value);
            if(last==null)  {
                last = node;
            }
            else  {
                node.next = last.next;
                last.next = node;
                node.prev = last;
                if(node.next!=null)  {
                    node.next.prev = node;
                }
                last = node;
            }
            map.put(key, node);
            capacity--;
        }
    }
}
