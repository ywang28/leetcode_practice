public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        if(A==null || A.length==0)  return -1;
        int maxSum = A[0], currSum = 0;
        for(int i=0; i<A.length; i++)  {
            currSum = (currSum < 0) ? A[i] : currSum + A[i];
            // ignore negative sum and start over
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
    public int maxSubArray2(int[] A) {
        if(A==null || A.length==0)  return 0;
        int max = A[0], curr = A[0];
        for(int i=1; i<A.length; i++)  {
            curr = Math.max(0, curr);
            curr += A[i];
            max = Math.max(curr, max);
        }
        return max;
    }
}
