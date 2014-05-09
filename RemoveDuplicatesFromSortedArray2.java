public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] A) {
        if(A==null)  return 0;
        if(A.length < 3)  return A.length;
        int curr = 0, next = 1;
        boolean dup = false;
        while(next < A.length)  {
            if(A[next] == A[curr])  {
                if(dup)  {
                    if(curr == 0 || A[curr] != A[curr-1])  curr++;
                }
                else  {
                    dup = true;
                    A[++curr] = A[next];
                }
            }
            else  {
                dup = false;
                A[++curr] = A[next];
            }
            next++;
        }
        return curr+1;
    }
    public int removeDuplicates2(int[] A) {
        if(A==null)  return 0;
        if(A.length<3)  return A.length;
        int prev = 0, curr = 1, counter = 1;
        for(;curr<A.length; curr++)  {
            if(A[curr]==A[prev])  {
                counter++;
                if(counter<3)  {
                    prev++;
                    A[prev] = A[curr];
                }
            }
            else  {
                prev++;
                A[prev] = A[curr];
                counter = 1;
            }
        }
        return prev+1;
    }
}
