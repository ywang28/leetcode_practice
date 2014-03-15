// pass
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m<1 || n<1)  return -1;
        if(m==1 || n==1)  return 1;
        int[] dp = new int[n];
        for(int i=0; i<n; i++)  {
            dp[i] = 1;
        }
        for(int j=1; j<m; j++)  {
            for(int i=1; i<n; i++)  {
                dp[i] = dp[i-1] + dp[i];
            }
        }
        return dp[n-1];
    }
}
