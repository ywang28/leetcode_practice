public class UniqueBinarySearchTree {
    public int numTrees(int n) {
        if(n<0)  return 0;
        if(n==0)  return 1;
        // catalan number
        int[] catalan = new int[n+1];
        catalan[0] = 1;
        for(int i=1; i<=n; i++)  {
            catalan[i] = 0;
            for(int j=0; j<i/2; j++)  {
                catalan[i] += 2 * catalan[j] * catalan[i-j-1];
            }
            // add center value for odd num
            if(i%2==1)  {
                catalan[i] += catalan[i/2] * catalan[i/2];
            }
        }
        return catalan[n];
    }
    public int numTrees2(int n) {
        if(n<0)  return 0;
        if(n==0||n==1)  return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int k=2; k<=n; k++)  {
            for(int i=0; i<k/2; i++)  {
                dp[k] += 2 * dp[i] * dp[k-1-i];
            }
            if(k%2==1)  {
                dp[k] += dp[k/2] * dp[k/2];
            }
        }
        return dp[n];
    }
}
