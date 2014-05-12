public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if(s1==null || s2==null || s1.length()!=s2.length())  return false;
        int len = s1.length();
        if(len==0)  return true;
        // dp[i][j][k] means substring starting from s1 index i and s2 index j with len k+1 is scrambled
        boolean[][][] dp = new boolean[len][len][len];
        // base case len=1
        for(int i=0; i<len; i++)  {
            for(int j=0; j<len; j++)  {
                dp[i][j][0] = s1.charAt(i)==s2.charAt(j);
            }
        }
        for(int k=1; k<len; k++)  {
            for(int i=0; i<len-k; i++)  {
                for(int j=0; j<len-k; j++)  {
                    for(int l=0; l<k; l++)  {
                        if((dp[i][j][l] && dp[i+l+1][j+l+1][k-l-1]) || (dp[i][j+k-l][l]) && dp[i+l+1][j][k-l-1])  {
                            dp[i][j][k] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][len-1];
    }
}
