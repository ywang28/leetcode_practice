public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
        if(A==null || A.length==0)  return 0;
        int i=0, j=1;
        for(; j<A.length; j++)  {
            if(A[j]!=A[i])  {
                A[i+1] = A[j];
                i++;
            }
        }
        return i+1;
    }
}
