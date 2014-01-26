public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        if(n<1)  return new int[0][0];
        int[][] ret = new int[n][n];
        int i=0, j=n-1, num=1, k;
        while(i<j)  {
            // fill 4 borders in turn
            for(k=i; k<j; k++)  {
                ret[i][k] = num++;
            }
            for(k=i; k<j; k++)  {
                ret[k][j] = num++;
            }
            for(k=n-1-i; k>n-1-j; k--)  {
                ret[j][k] = num++;
            }
            for(k=n-1-i; k>n-1-j; k--)  {
                ret[k][i] = num++;
            }
            i++;
            j--;
        }
        // add last num for odd n
        if(n % 2==1)  {
            int mid = n/2;
            ret[mid][mid] = num;
        }
        return ret;
    }
}
