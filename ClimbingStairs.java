public class ClimbingStairs {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n<1)  return 0;
        if(n==1)  return 1;
        if(n==2)  return 2;
        int[] sol = new int[n+1];
        sol[0] = 0;
        sol[1] = 1;
        sol[2] = 2;
        for(int i=3; i<=n; i++)  {
            sol[i] = sol[i-1] + sol[i-2];
        }
        return sol[n];
    }
    public int climbStairs2nd(int n) {
        if(n < 0)  return 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        return climbHelper(n, dp);
    }
    public int climbHelper(int n, int[] dp)  {
        if(dp[n]!=0)  return dp[n];
        dp[n] = climbHelper(n-1, dp) + climbHelper(n-2, dp);
        return dp[n];
    }
    public int climbStairs3(int n) {
        if(n<=0)  return 0;
        if(n==1)  return 1;
        if(n==2)  return 2;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2; i<n; i++)  {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
}
