public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        if(num == null || num.length==0)  return 0;
        if(num.length == 1)  return 1;
        int count = 1;
        HashMap<Integer,Boolean> visited = new HashMap<Integer,Boolean>();
        // hash map to save if the num is visited
        for(int i=0; i<num.length; i++)  {
            visited.put(num[i], false);
        }
        for(int i=0; i<num.length; i++)  {
            // already visited
            int currNum = num[i];
            if(visited.get(currNum))  continue;
            int currCnt = 1;
            // count down
            while(visited.containsKey(currNum-1))  {
                currCnt++;
                visited.put(currNum-1, true);
                currNum--;
            }
            // reset currNum and count up
            currNum = num[i];
            while(visited.containsKey(currNum+1))  {
                currCnt++;
                visited.put(currNum+1, true);
                currNum++;
            }
            count = Math.max(count, currCnt);
        }
        return count;
    }
}
