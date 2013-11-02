public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        if(A==null || A.length==0)  return 0;
        int start = 0;
        int end = A.length-1;
        int mid;
        while(start<=end)  {
            mid = start + (end-start)/2;
            if(A[mid]==target)  return mid;
            if(A[mid]>target)  {
                end = mid-1;
            }
            else  {
                start = mid+1;
            }
        }
        return start;
    }
}
