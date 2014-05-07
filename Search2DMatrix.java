public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)  return false;
        int xlen = matrix.length, ylen = matrix[0].length;
        int startX = 0, startY = 0, endX = xlen-1, endY = ylen-1, midX, midY;
        // modified binary search
        while(startX < endX || (startX == endX && startY <= endY))  {
            // get length of current region
            int len = (endX - startX) * ylen + endY - startY;
            int offset = startY + len/2;
            midY = offset % ylen;
            midX = startX + offset / ylen;
            if(matrix[midX][midY] == target)  {
                return true;
            }
            else if(matrix[midX][midY] > target)  {
                // deal with edge cases
                if(midY == 0)  {
                    endY = ylen-1;
                    endX = midX-1;
                }
                else  {
                    endY = midY-1;
                    endX = midX;
                }
            }
            else  {
                if(midY == ylen-1)  {
                    startY = 0;
                    startX = midX+1;
                }
                else  {
                    startY = midY+1;
                    startX = midX;
                }
            }
        }
        return false;
    }
    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)  return false;
        int xlen = matrix.length, ylen = matrix[0].length;
        int start = 0, end = xlen-1, mid = start+(end-start)/2;
        // end will be the row number lies in
        while(start<=end)  {
            mid = start + (end-start)/2;
            if(matrix[mid][0]==target)  {
                return true;
            }
            else if(matrix[mid][0]>target)  {
                end = mid-1;
            }
            else  {
                start = mid+1;
            }
        }
        if(end<0)  return false;
        int rowIndex = end;
        start = 0;
        end = ylen-1;
        while(start<=end)  {
            mid = start + (end-start)/2;
            if(matrix[rowIndex][mid]==target)  {
                return true;
            }
            else if(matrix[rowIndex][mid]>target)  {
                end = mid-1;
            }
            else  {
                start = mid+1;
            }
        }
        return false;
    }
}
