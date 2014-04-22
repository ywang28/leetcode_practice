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
    public int[] searchRange2(int[] A, int target) {
        int[] ret = new int[]{-1,-1};
        if(A==null || A.length==0)  return ret; 
        int start=0, end=A.length-1, mid;
        while(start<=end)  {
            mid = start + (end-start)/2;
            if(A[mid]==target)  {
                int left = mid, right = mid;
                while(left>0 && A[left-1]==target)  {
                    left--;
                }
                while(right<A.length-1 && A[right+1]==target)  {
                    right++;
                }
                ret[0] = left;
                ret[1] = right;
                return ret;
            }
            else if(A[mid]>target)  {
                end = mid-1;
            }
            else  {
                start = mid+1;
            }
        }
        return ret;
    }
}
