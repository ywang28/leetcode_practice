// 2nd try. Pass
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0)  return 0;
        int xLen = grid.length;
        int yLen = grid[0].length;
        int[][] dp = new int[xLen][yLen];
        for(int i=0; i<xLen; i++)  {
            for(int j=0; j<yLen; j++)  {
                dp[i][j] = -1;
            }
        }
        dp[xLen-1][yLen-1] = grid[xLen-1][yLen-1];
        return findPathSum(grid,dp,0,0);
    }
    public int findPathSum(int[][] grid, int[][] dp, int x, int y)  {
        if(x > grid.length-1 || y > grid[0].length-1)  return Integer.MAX_VALUE;
        if(dp[x][y]!=-1)  return dp[x][y];
        dp[x][y] = grid[x][y] + Math.min(findPathSum(grid,dp,x+1,y), findPathSum(grid,dp,x,y+1));
        return dp[x][y];
    }
    public int minPathSum2(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0)  return 0;
        int xlen = grid.length, ylen = grid[0].length;
        int[] dp = new int[ylen];
        // fill in dp table
        for(int i=0; i<xlen; i++)  {
            for(int j=0; j<ylen; j++)  {
                if(i==0)  {
                    dp[j] = grid[i][j] + ((j==0) ? 0 : dp[j-1]);
                }
                else if(j==0)  {
                    dp[j] = grid[i][j] + ((i==0) ? 0 : dp[j]);
                }
                else  {
                    dp[j] = grid[i][j] + Math.min(dp[j-1],dp[j]);
                }
            }
        }
        return dp[ylen-1];
    }
}
