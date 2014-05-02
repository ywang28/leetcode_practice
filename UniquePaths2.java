public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0].length==0)  return 0;
        int xlen = obstacleGrid.length, ylen = obstacleGrid[0].length;
        int[][] dp = new int[xlen][ylen];
        // initialize dp table
        for(int i=0; i<xlen; i++)  {
            for(int j=0; j<ylen; j++)  {
                dp[i][j] = -1;
            }
        }
        return pathHelper(obstacleGrid, xlen-1, ylen-1, dp);
    }
    public int pathHelper(int[][] obstacleGrid, int m, int n, int[][] dp)  {
        if(dp[m][n]!=-1)  {
            return dp[m][n];
        }
        if(obstacleGrid[m][n]==1)  {
            dp[m][n] = 0;
        }
        else if(m==0 && n==0)  {
            dp[m][n] = 1;
        }
        else if(m==0)  {
            dp[m][n] = pathHelper(obstacleGrid, m, n-1, dp);
        }
        else if(n==0)  {
            dp[m][n] = pathHelper(obstacleGrid, m-1, n, dp);
        }
        else  {
            dp[m][n] = pathHelper(obstacleGrid, m-1, n, dp) + pathHelper(obstacleGrid, m, n-1, dp);
        }
        return dp[m][n];
    }
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if(obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0].length==0 || obstacleGrid[0][0]==1)  return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        fillDP(obstacleGrid, dp);
        return dp[m-1][n-1];
    }
    public void fillDP(int[][] obstacleGrid, int[][] dp)  {
        for(int i=1; i<dp.length; i++)  {
            dp[i][0] = obstacleGrid[i][0]==1  ? 0 : dp[i-1][0];
        }
        for(int j=1; j<dp[0].length; j++)  {
            dp[0][j] = obstacleGrid[0][j]==1 ? 0 : dp[0][j-1];
        }
        for(int i=1; i<dp.length; i++)  {
            for(int j=1; j<dp[0].length; j++)  {
                dp[i][j] = obstacleGrid[i][j]==1 ? 0 : dp[i][j-1]+dp[i-1][j];
            }
        }
    }
}
