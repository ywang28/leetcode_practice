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
}
