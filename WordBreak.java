public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s==null || dict==null || dict.size()==0)  return false;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        // initialize to record single char string breaks
        // dp[i][j]:  string index from i to j can be segmented
        for(int i=0; i<len; i++)  {
            dp[i][i] = dict.contains(s.substring(i,i+1));
        }
        // fill up dp table
        for(int i=len-2; i>=0; i--)  {
            for(int j=i+1; j<len; j++)  {
                // itself is in dict
                if(dict.contains(s.substring(i, j+1)))  {
                    dp[i][j] = true;
                    continue;
                }
                // substring partition can be segmented
                for(int k=i; k<j; k++)  {
                    if(dp[i][k] && dp[k+1][j])  {
                        dp[i][j] = true;
                        break;
                    }
                }
            }
        }
        return dp[0][len-1];
    }
}
