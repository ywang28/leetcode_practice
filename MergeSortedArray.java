public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        if(A==null || A.length==0 || B==null || B.length==0)  return;
        int i = m-1, j = n-1;
        // fill in the result backwords
        for(int k = m+n-1; k>=0; k--)  {
            if(i < 0)  {
                A[k] = B[j--];
            }
            else if(j < 0)  {
                A[k] = A[i--];
            }
            else  {
                A[k] = (A[i] > B[j]) ? A[i--] : B[j--];
            }
        }
    }
    public void merge2(int A[], int m, int B[], int n) {
        if(A==null || B==null || B.length==0 || n<1)  return;
        for(int i = m-1, j = n-1, k = m+n-1; k>=0; k--)  {
            if(i<0)  {
                A[k] = B[j--];
            }
            else if(j<0)  {
                A[k] = A[i--];
            }
            else if(A[i]>B[j])  {
                A[k] = A[i--];
            }
            else  {
                A[k] = B[j--];
            }
        }
    }
}
