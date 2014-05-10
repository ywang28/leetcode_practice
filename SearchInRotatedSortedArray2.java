// pass 2nd
public class SearchInRotatedSortedArray2 {
    public boolean search(int[] A, int target) {
        if(A==null || A.length==0)  return false;
        int begin = 0, end = A.length-1, mid;
        while(begin<=end)  {
            mid = begin + (end-begin)/2;
            System.out.println(mid);
            if(A[mid]==target)  return true;
            if(mid==begin) {
                begin = mid+1;
            }
            else if(A[mid]>A[begin]) {
                if(A[mid]<target || A[begin]>target)  {
                    begin = mid+1;
                }
                else  {
                    end = mid-1;
                }
            }
            else  {
                if(A[mid]>target || A[end]<target)  {
                    end = mid-1;
                }
                else  {
                    begin = mid+1;
                }
            }
        }
        return false;
    }
    public static void main(String[] Args)  {
        SearchInRotatedSortedArray2 s = new SearchInRotatedSortedArray2();
        System.out.println(s.search(new int[]{3,1},1));
    }
    public boolean search2(int[] A, int target) {
        if(A==null || A.length==0)  return false;
        int start = 0, end = A.length-1, mid = start + (end-start)/2;
        while(start<=end)  {
            mid = start + (end-start)/2;
            if(A[mid]==target)  return true;
            // right side is rotated
            if(A[mid]>A[start])  {
                // target is within left half
                if(target>=A[start] && target<A[mid])  {
                    end = mid-1;
                }
                else  {
                    start = mid+1;
                }
            }
            // left side is rotated
            else if(A[mid]<A[start])  {
                if(target>A[mid] && target<=A[end])  {
                    start = mid+1;
                }
                else  {
                    end = mid-1;
                }
            }
            // remove duplicates
            else  {
                while(start<=mid && A[mid]==A[start]) {
                    start++;
                }
                // leftside is not all duplicates
                if(start<mid)  {
                    end = mid-1;
                }
            }
        }
        return false;
    }
}
