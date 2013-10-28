public class Solution {
    public boolean canJump(int[] A) {
        if(A==null || A.length<2)  return true;
        // DP table. 0: not decided. 1: jumpable. -1: unjumpable
        int[] jump = new int[A.length];
        jump[A.length-1] = 1;
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
}
