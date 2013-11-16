import java.util.*;
public class RotateImage {
    public void rotate(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0 || matrix.length!=matrix[0].length)  return;
        int start = 0, end = matrix.length-1;
        while(start < end)  {
            for(int i=start; i<end; i++)  {
                swap(matrix, start, i, i, end);
                swap(matrix, start, i, end, end-i+start);
                swap(matrix, start, i, end-i+start, start);
            }
            start++;
            end--;
        }
    }
    public void swap(int[][] matrix, int i, int j, int p, int q)  {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[p][q];
        matrix[p][q] = tmp;
    }
    public static void main(String[] Args)  {
        RotateImage r = new RotateImage();
        int[][] t = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        for(int[] each : t)  {
            System.out.println(Arrays.toString(each));
        }
        r.rotate(t);
        for(int[] each : t)  {
            System.out.println(Arrays.toString(each));
        }
        t = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        for(int[] each : t)  {
            System.out.println(Arrays.toString(each));
        }
        r.rotate(t);
        for(int[] each : t)  {
            System.out.println(Arrays.toString(each));
        }
    }
}
