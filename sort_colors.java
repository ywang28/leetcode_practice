public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null || A.length<=1)  return;
        int red = 0;
        int white = 0;
        int blue = A.length-1;
        while(white<=blue)  {
            if(A[white]==0)  {
                swap(A,red,white);
                red++;
                white++;
            }
            else if(A[white]==2)  {
                swap(A,white,blue);
                blue--;
            }
            else  {
                white++;
            }
        }
    }
    public void swap(int[] A, int p, int q)  {
        int tmp = A[p];
        A[p] = A[q];
        A[q] = tmp;
    }
}
