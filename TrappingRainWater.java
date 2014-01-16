public class TrappingRainWater {
    public int trap(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(A==null || A.length<3)  return 0;
        int total = 0, len = A.length, lastHigh = A[0];
        int cumSum = 0;
        boolean trap = false;
        // scan through each node
        for(int i=1; i<len; i++)  {
            if(A[i]>=lastHigh && !trap)  {
                lastHigh = A[i];
            }
            else if(A[i]<lastHigh)  {
                trap = true;
                cumSum += lastHigh - A[i];
            }
            else if(A[i]>=lastHigh && trap)  {
                lastHigh = A[i];
                total += cumSum;
                cumSum = 0;
                trap = false;
            }
        }
        cumSum = 0;
        lastHigh = A[len-1];
        // scan reverse only when strictly higher will add to total
        for(int i=len-2; i>=0; i--)  {
            if(A[i]>=lastHigh && !trap)  {
                lastHigh = A[i];
            }
            else if(A[i]<lastHigh)  {
                trap = true;
                cumSum += lastHigh - A[i];
            }
            else if(A[i]>lastHigh && trap)  {
                lastHigh = A[i];
                total += cumSum;
                cumSum = 0;
                trap = false;
            }
        }
        return total;
    }
}
