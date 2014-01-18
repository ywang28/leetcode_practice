public class JumpGame2 {
    public int jump(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(A==null || A.length<2)  return 0;
        // use dp table to save time
        return jumpHelper(A, 0, new int[A.length]);
    }
    public int jumpHelper(int[] A, int index, int[] table)  {
        if(table[index] != 0)  return table[index];
        // can't reach end
        if(A[index] == 0)  {
            table[index] = Integer.MAX_VALUE;
            return Integer.MAX_VALUE;
        }
        // last step is enough to reach end
        if(A[index] >= A.length-1-index)  {
            table[index] = 1;
            return 1;
        }
        int minStep = Integer.MAX_VALUE;
        for(int i=1; i<=A[index]; i++)  {
            // when 6,5,4,3,2 is met, they have equal solution
            if(A[index+i]==A[index]-i)  continue;
            minStep = Math.min(minStep, jumpHelper(A, index+i, table));
        }
        table[index] = (minStep == Integer.MAX_VALUE) ? minStep : minStep+1;
        return table[index];
    }
}
