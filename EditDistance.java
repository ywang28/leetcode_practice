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
    public int minDistance2(String word1, String word2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(word1==null || word1.length()==0)  return word2==null ? 0 : word2.length();
        if(word2==null || word2.length()==0)  return word1.length();
        int len1 = word1.length(), len2 = word2.length();
        // dp[i][j] records edit distance from word1.substring(i) to word2.substring(j)
        int[][] dp = new int[len1][len2];
        for(int i=0; i<len1; i++)  {
            for(int j=0; j<len2; j++)  {
                dp[i][j] = -1;
            }
        }
        return distHelper(word1, 0, word2, 0, dp);
    }
    public int distHelper(String word1, int index1, String word2, int index2, int[][] dp)  {
        if(index1==word1.length())  {
            return (index2==word2.length()) ? 0 : word2.length()-index2;
        }
        if(index2==word2.length())  {
            return word1.length()-index1;
        }
        if(dp[index1][index2]!=-1)  return dp[index1][index2];
        if(word1.charAt(index1)==word2.charAt(index2))  {
            dp[index1][index2] = distHelper(word1, index1+1, word2, index2+1, dp);
        }
        else  {
            dp[index1][index2] = Math.min(Math.min(distHelper(word1, index1, word2, index2+1, dp), distHelper(word1, index1+1, word2, index2+1,dp)), distHelper(word1, index1+1, word2, index2, dp)) + 1;
        }
        return dp[index1][index2];
    }
}
