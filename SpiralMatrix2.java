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
    public int[][] generateMatrix2(int n) {
        if(n<1)  return new int[0][0];
        int[][] ret = new int[n][n];
        int sx = 0, sy = 0, ex = n-1, ey = n-1, cnt = 1;
        while(sx<=ex && sy<=ey)  {
            // last num left
            if(sx==ex)  {
                ret[sx][sy] = cnt;
            }
            else  {
                // go east
                for(int j=sy; j<ey; j++)  {
                    ret[sx][j] = cnt++;
                }
                // go south
                for(int i=sx; i<ex; i++)  {
                    ret[i][ey] = cnt++;
                }
                // go west
                for(int j=ey; j>sy; j--)  {
                    ret[ex][j] = cnt++;
                }
                // go north
                for(int i=ex; i>sx; i--)  {
                    ret[i][sy] = cnt++;
                }
            }
            sx++;
            sy++;
            ex--;
            ey--;
        }
        return ret;
    }
}
