public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(matrix==null || matrix.length==0 || matrix[0].length==0)  return ans;
        int xlength = matrix.length;
        int ylength = matrix[0].length;
        int xstart = 0;
        int xend = xlength-2;
        int ystart = 0;
        int yend = ylength-2;
        int i;
        while(xstart<=xend && ystart<=yend)  {
            for(i=ystart; i<=yend; i++)  {
                ans.add(matrix[xstart][i]);
            }
            for(i=xstart; i<=xend; i++)  {
                ans.add(matrix[i][yend+1]);
            }
            for(i=ylength-1-ystart; i>=ylength-1-yend; i--)  {
                ans.add(matrix[xend+1][i]);
            }
            for(i=xlength-1-xstart; i>=xlength-1-xend; i--)  {
                ans.add(matrix[i][ystart]);
            }
            xstart++;
            xend--;
            ystart++;
            yend--;
        }
        // No more data left
        if(xstart-xend==2 || ystart-yend==2)  return ans;
        // Extra row or column is left
        if(xstart>xend)  {
            for(i=ystart; i<=yend+1; i++)  {
                ans.add(matrix[xstart][i]);
            }
        }
        else  {
            for(i=xstart; i<=xend+1; i++)  {
                ans.add(matrix[i][ystart]);
            }
        }
        return ans;
    }
}
