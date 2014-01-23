public class JumpGame {
    public boolean canJump(int[] A) {
        if(A==null || A.length<2)  return true;
        // DP table. 0: not decided. 1: jumpable. -1: unjumpable
        int[] jump = new int[A.length];
        jump[A.length-1] = 1;
        for(int i=A.length-2; i>=0; i--)  {
            if(A[i]==0)  {
                jump[i] = -1;
                continue;
            }
            // counting down nums are same subproblem
            if(A[i]-A[i+1]==1)  {
                jump[i] = jump[i+1];
            }
        }
        return canJumpHelper(A,0,jump) == 1 ;
    }
    public int canJumpHelper(int[] A, int index, int[] jump)  {
        if(index > A.length-1)  return -1;
        if(jump[index]!=0)  return jump[index];
        // If any subpath is jumpable, return jumpable
        for(int i=1; i<=A[index]; i++)  {
            if(canJumpHelper(A,index+i,jump) == 1)  jump[index] = 1;
        }
        jump[index] = -1;
        return jump[index];
    }
    public boolean canJump2nd(int[] A) {
        if(A==null || A.length<2)  return true;
        return canJumpHelper2nd(A, 0, new int[A.length]);
    }
    // dp table: -1 can't jump; 1 can jump; 0 not decided
    public boolean canJumpHelper2nd(int[] A, int index, int[] dp)  {
        if(dp[index]!=0)  return (dp[index]==1) ? true : false;
        // can directly jump
        if(A[index] > A.length-2-index)  {
            dp[index] = 1;
            return true;
        }
        for(int i=index+1; i<=index+A[index]; i++)  {
            // 3,2,1 pattern found. continue
            if(A[i] == A[i-1]-1)  continue;
            if(canJumpHelper2nd(A, i, dp))  {
                dp[index] = 1;
                return true;
            }
        }
        dp[index] = -1;
        return false;
    }
}
