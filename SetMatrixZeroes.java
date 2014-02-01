public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)  return;
        int xlen = matrix.length, ylen = matrix[0].length;
        boolean row0 = false, col0 = false;
        // check first row and column
        for(int i=0; i<xlen; i++)  {
            if(matrix[i][0]==0)   {
                col0 = true;
                break;
            }
        }  
        for(int j=0; j<ylen; j++)  {
            if(matrix[0][j]==0)  {
                row0 = true;
                break;
            }
        }
        // set 0 in row0 and col0 if any elem in same row/col is 0
        for(int i=1; i<xlen; i++)  {
            for(int j=1; j<ylen; j++)  {
                if(matrix[i][j]==0)  {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // set corresponding row/col to 0 except first row/col
        for(int i=1; i<xlen; i++)  {
            if(matrix[i][0]==0)  {
                for(int j=1; j<ylen; j++)  {
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j=1; j<ylen; j++)  {
            if(matrix[0][j]==0)  {
                for(int i=1; i<xlen; i++)  {
                    matrix[i][j] = 0;
                }
            }
        }
        // set row0 and col0 to 0 if needed
        if(row0)  {
            for(int j=0; j<ylen; j++)  matrix[0][j] = 0;
        }
        if(col0)  {
            for(int i=0; i<xlen; i++)  matrix[i][0] = 0;
        }
    }
}
