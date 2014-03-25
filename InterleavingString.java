public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3==null) return false;
        if(s1==null && s2==null)  return s3.length()==0;
        if(s1==null || s1.length()==0)  return s3.equals(s2);
        if(s2==null || s2.length()==0)  return s3.equals(s1);
        if(s3.length() != s1.length()+s2.length())  return false;
        int m = s1.length(), n = s2.length();
        // dp[x][y] means if first x+y chars in s3 is interleave of x chars in s1 and y chars in s2
        boolean[][] dp = new boolean[m+1][n+1];
        for(int i=1; i<m+1; i++)  {
            dp[i][0] = s1.charAt(i-1) == s3.charAt(i-1);
        }
        for(int j=1; j<n+1; j++)  {
            dp[0][j] = s2.charAt(j-1) == s3.charAt(j-1);
        }
        for(int i=1; i<m+1; i++)  {
            for(int j=1; j<n+1; j++)  {
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }
        return dp[m][n];
    }
}
