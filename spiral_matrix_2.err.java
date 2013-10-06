public class Solution {
    class indexXY  {
        int x;
        int y;
        int num;
        indexXY(int x, int y, int num)  {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n<1)  return null;
        int[][] res = new int[n][n];
        boolean fillX = true;
        int eachStep = 1;
        indexXY next = new indexXY(0,0,1);
        int steps = n;
        while(steps>0)  {
            fillMatrix(fillX,eachStep,res,next,steps);
            fillX = !fillX;
            if(fillX)  {
                steps--;
                next.x += eachStep;
            }
            else {
                eachStep = -eachStep;
                next.y += eachStep;
            }
        }
        return res;
    }
    public void fillMatrix(boolean fillX, int eachStep, int[][] matrix, indexXY next, int steps)  {
        for(int i=0; i<steps; i++)  {
            matrix[next.x][next.y] = next.num;
            next.num++;
            if(fillX)  {
                next.x += eachStep;
            }
            else  {
                next.y += eachStep;
            }
        }
    }
}
