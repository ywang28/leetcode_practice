/**
  假设你是harry potter，在grid的左上角，你现在要走到右下角，grid中有
  正数也有负数，遇到正数表示你的strength增加那么多，遇到负数表示strength减少那
  么多，在任何时刻如果你的strength小于等于0，那么你就挂了。在一开始你有一定的
  初始的strength，现在问这个初始的strength最少是多少，才能保证你能够找到一条路
  走到右下角。每次只能往右或者往下走。
*/  
import java.util.ArrayList;

public class HarryPotter  {
    public static void main(String[] Args)  {
        HarryPotter t = new HarryPotter();
        int[][] grid = {{1,5,-2,4},{3,-4,0,1},{-3,-12,-11,-13},{-2,1,4,0}};
        t.test(grid);
    }
    public int solve(int[][] grid)  {
        if(grid==null || grid.length==0 || grid[0].length==0)  return -1;
        ArrayList<Integer> stren = new ArrayList<Integer>();
        // starting point has 0 strength requirement
        findStrength(grid, 0, 0, 0, 0, stren);
        int minStren = stren.get(0);
        for(int st : stren)  {
            minStren = Math.min(minStren, st);
        }
        return minStren;
    }
    // brutal force
    public void findStrength(int[][] grid, int i, int j, int strength, int accu, ArrayList<Integer> stren)  {
        // if at the end point
        if(i == grid.length-1 && j == grid[0].length-1)  {
            stren.add(strength);
            return;
        }
        // ignore starting point
        if(i+j != 0)  {
            accu += grid[i][j];
        }
        // any time accumulative sum is negative, set abs value as required stength to reach this point
        // and clear accumulative sum to zero
        if(accu < 0)  {
            strength = Math.max(strength, -accu+1);
            accu = 0;
        }
        // last line. explore right
        if(i == grid.length-1)  {
            findStrength(grid, i, j+1, strength, accu, stren);
        }
        // last column. explore down
        else if(j == grid[0].length-1)  {
            findStrength(grid, i+1, j, strength, accu, stren);
        }
        // explore right and down
        else  {
            findStrength(grid, i+1, j, strength, accu, stren);
            findStrength(grid, i, j+1, strength, accu, stren);
        }
    }
    public void test(int[][] grid)  {
        System.out.println("input: " + Formatter.flat(grid));
        System.out.println("output: " + solve(grid));
    }
}
