// Time limit exceeded
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if(grid==null)  return 0;
        return findPathSum(grid,0,0);
    }
    public int findPathSum(int[][] grid, int x, int y)  {
        if(x > grid.length-1 || y > grid[0].length-1)  return Integer.MAX_VALUE;
        if(x==grid.length-1 && y==grid[0].length-1)  return grid[x][y];
        return grid[x][y] + Math.min(findPathSum(grid,x+1,y), findPathSum(grid,x,y+1));
    }
}
