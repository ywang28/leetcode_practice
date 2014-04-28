public class SpiralMatrix {
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
    public ArrayList<Integer> spiralOrder2nd(int[][] matrix) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(matrix==null || matrix.length==0 || matrix[0].length==0)  return ret;
        int xlen = matrix.length, ylen = matrix[0].length, sx = 0, sy = 0, ex = xlen-1, ey = ylen-1;
        while(sx <= ex && sy <=ey)  {
            // last row left
            if(sx==ex)  {
                for(int i=sy; i<=ey; i++)  {
                    ret.add(matrix[sx][i]);
                }
            }
            // last column left
            else if(sy==ey)  {
                for(int i=sx; i<=ex; i++)  {
                    ret.add(matrix[i][sy]);
                }
            }
            // add 4 edges in turn
            else  {
                for(int i=sy; i<ey; i++)  {
                    ret.add(matrix[sx][i]);
                }
                for(int i=sx; i<ex; i++)  {
                    ret.add(matrix[i][ey]);
                }
                for(int i=ey; i>sy; i--)  {
                    ret.add(matrix[ex][i]);
                }
                for(int i=ex; i>sx; i--)  {
                    ret.add(matrix[i][sy]);
                }
            }
            // increment pointers
            sx++;
            sy++;
            ex--;
            ey--;
        }
        return ret;
    }
    public ArrayList<Integer> spiralOrder3(int[][] matrix) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(matrix==null || matrix.length==0 || matrix[0].length==0)  return ret;
        int xlen = matrix.length, ylen = matrix[0].length, sx = 0, sy = 0, ex = xlen-1, ey = ylen-1, i;
        while(sx<=ex && sy<=ey)  {
            if(sx==ex)  {
                for(int j=sy; j<=ey; j++)  {
                    ret.add(matrix[sx][j]);
                }
                return ret;
            }
            if(sy==ey)  {
                for(int j=sx; j<=ex; j++)  {
                    ret.add(matrix[j][sy]);
                }
                return ret;
            }
            // go east
            for(i=sy; i<ey; i++)  {
                ret.add(matrix[sx][i]);
            }
            // go south
            for(i=sx; i<ex; i++)  {
                ret.add(matrix[i][ey]);
            }
            // go west
            for(i=ey; i>sy; i--)  {
                ret.add(matrix[ex][i]);
            }
            // go north
            for(i=ex; i>sx; i--)  {
                ret.add(matrix[i][sy]);
            }
            sx++;
            sy++;
            ex--;
            ey--;
        }
        return ret;
    }
}
