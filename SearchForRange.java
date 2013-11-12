public class SearchForRange {
    public int[] searchRange(int[] A, int target) {
        int[] ans = new int[]{-1,-1};
        if(A==null || A.length==0)  return ans;
        binarySearch(A, target, 0, A.length-1, ans);
        return ans;
    }
    public void binarySearch(int[] A, int target, int begin, int end, int[] ans)  {
        if(begin > end)  return;
        int mid = begin + (end-begin)/2;
        if(A[mid]==target)  {
            ans[0] = (ans[0]==-1) ? mid : Math.min(ans[0], mid);
            ans[1] = Math.max(ans[1], mid);
            binarySearch(A, target, mid+1, end, ans);
            binarySearch(A, target, begin, mid-1, ans);
        }
        else if(A[mid]<target)  {
            binarySearch(A, target, mid+1, end, ans);
        }
        else  {
            binarySearch(A, target, begin, mid-1, ans);
        }
    }
}
