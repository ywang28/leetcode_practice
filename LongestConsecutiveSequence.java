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
    public int longestConsecutive2nd(int[] num) {
        if (num == null || num.length == 0)  return 0;
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int counter  = 1, maxCount = 1;
        for (int i = 0; i < num.length; i++)  {
            map.put(num[i], true);
        }
        for(int n : map.keySet())  {
            if (map.get(n))  {
                counter = 1;
                int m = n;
                // check overflow case of n
                while (map.containsKey(n - 1))  {
                    counter++;
                    map.put(n - 1, false);
                    n--;
                }
                while (map.containsKey(m + 1))  {
                    counter++;
                    map.put(m + 1, false);
                    m++;
                }
            } // end if map.get(n)
            maxCount = Math.max(maxCount, counter);
        }
        return maxCount;
    }
    // brute force
    public int longestConsecutive3rd(int[] num) {
        if (num == null || num.length == 0)  return 0;
        // example [1, 2, 3, 3, 5]
        // O(nlog(n))
        Arrays.sort(num);
        int counter = 1, maxCount = 1;
        for (int i = 1; i < num.length; i++)  {
            // a consecutive number is found
            if (num[i] == num[i-1] + 1)  {
                counter++;
                maxCount = Math.max(maxCount, counter);
            }
            // ignore duplicates. e,g [2, 3, 3, 3, 4]
            else if (num[i] == num[i-1])  {
                continue;
            }
            // sequence is broken. reset the counter
            else  {
                counter = 1;
            }
        }
        // return max counter
        return maxCounter;
    }
}
