public class PalindromePartitioning {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        if(s==null || s.length()==0)  return ret;
        int len = s.length();
        boolean[][] isPalin = new boolean[len][len];
        for(int i=0; i<len; i++)  {
            isPalin[i][i] = true;
        }
        for(int i=len-2; i>=0; i--)  {
            for(int j=i+1; j<len; j++)  {
                if(j==i+1)  {
                    isPalin[i][j] = s.charAt(i) == s.charAt(j);
                }
                else  {
                    isPalin[i][j] = isPalin[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                }
            }
        }
        addPartition(s, 0, isPalin, ret, new ArrayList<String>());
        return ret;
    }
    //DFS
    public void addPartition(String s, int index, boolean[][] isPalin, ArrayList<ArrayList<String>> ret, ArrayList<String> curr)  {
        int len = s.length();
        if(index > len-1)  {
            ret.add(new ArrayList<String>(curr));
            return;
        }
        for(int i=index; i<len; i++)  {
            if(isPalin[index][i])  {
                curr.add(s.substring(index, i+1));
                addPartition(s, i+1, isPalin, ret, curr);
                curr.remove(curr.size()-1);
            }
        }
    }
}
