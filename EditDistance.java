public class EditDistance {
    public int minDistance(String word1, String word2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(word1 == null || word2==null)  return 0;
        int xlen = word1.length(), ylen = word2.length();
        if(xlen==0)  return ylen;
        if(ylen==0)  return xlen;
        // dp[i][j] records min edit distance from word1 0-i to word2 0-j excluding i, j
        int[][] dp = new int[xlen+1][ylen+1];
        // initialize base case for dp[0][*] and dp[*][0]
        for(int i=0; i<=xlen; i++)  dp[i][0] = i;
        for(int j=0; j<=ylen; j++)  dp[0][j] = j;
        // grow the table
        for(int i=0; i<xlen; i++)  {
            for(int j=0; j<ylen; j++)  {
                if(word1.charAt(i)==word2.charAt(j))  {
                    dp[i+1][j+1] = dp[i][j];
                }
                else  {
                    dp[i+1][j+1] = Math.min(dp[i][j], Math.min(dp[i+1][j], dp[i][j+1])) + 1;
                }
            }
        }
        return dp[xlen][ylen];
    }
}
