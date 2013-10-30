public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        if(A==null || A.length==0)  return 0;
        int start = 0;
        int end = A.length-1;
        while(start <= end)  {
            if(A[start] == elem)  {
                // swap elem to the end
                int tmp = A[start];
                A[start] = A[end];
                A[end] = tmp;
                end--;
            }
            else  {
                // check next elem
                start++;
            }
        }
        // end points to last non-elem position
        return end+1;
    }
}
