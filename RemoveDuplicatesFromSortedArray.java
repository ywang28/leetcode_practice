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
    public int removeDuplicates2(int[] A) {
        if(A==null || A.length<2)  return A.length;
        int start = 0, end = 1;
        for(; end<A.length; end++)  {
            if(A[end]!=A[start])  {
                start++;
                A[start] = A[end];
            }
        }
        return start+1;
    }
}
