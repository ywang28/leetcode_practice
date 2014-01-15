public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(A==null || A.length==0)  return 1;
        int len = A.length;
        // swap value with A[value] until out of range value found or value==A[value] found
        for(int i=0; i<len; i++)  {
            while(A[i]>=1 && A[i]<=len && A[i]!=i+1)  {
                int tmp = A[i];
                // repeated num found
                if(A[i] == A[tmp-1])  break;
                A[i] = A[tmp-1];
                A[tmp-1] = tmp;
            }
        }
        // scan a second time and find out missing num
        for(int i=0; i<len; i++)  {
            if(A[i] != i+1)  return i+1;
        }
        // all in sequence. eg. 1,2,3 then missing 4
        return len+1;
    }
}
