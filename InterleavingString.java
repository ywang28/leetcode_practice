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
    public boolean isInterleave2nd(String s1, String s2, String s3) {
        if(s1==null || s2==null || s3==null)  return false;
        if(s1.length()+s2.length()!=s3.length())  return false;
        int len1 = s1.length(), len2 = s2.length();
        // dp[i][j]:  s3 0 to i+j is interleave of s1 from 0 to i and s2 from 0 to j
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for(int i=1; i<=len1; i++)  {
            dp[i][0] = s1.substring(0,i).equals(s3.substring(0,i));
        }
        for(int j=0; j<=len2; j++)  {
            dp[0][j] = s2.substring(0,j).equals(s3.substring(0,j));
        }
        for(int i=0; i<len1; i++)  {
            for(int j=0; j<len2; j++)  {
                dp[i+1][j+1] = (dp[i][j+1] && s1.charAt(i) == s3.charAt(i+j+1)) || (dp[i+1][j] && s2.charAt(j) == s3.charAt(i+j+1));
            }
        }
        return dp[len1][len2];
    }
}
