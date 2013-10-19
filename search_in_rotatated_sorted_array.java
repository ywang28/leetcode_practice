public class Solution {
    public int search(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(A==null || A.length==0)  return -1;
        int start = 0;
        int end = A.length-1;
        int mid;
        while(start<=end)  {
            mid = (start + end)/2;
            if(A[mid]==target)  return mid;
            // if left is in order and target is within left range, or right is in order but target is out of right range, search left
            if((A[mid]>A[start]&&A[start]<=target&&A[mid]>target)||(A[mid]<A[start]&&(A[mid]>target||A[end]<target)))  {
                end = mid-1;
            }
            else  {
                start = mid+1;
            }
        }
        return -1;
    }
}
