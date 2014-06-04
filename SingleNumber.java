public class SingleNumber {
    public int singleNumber(int[] A) {
        if(A==null || A.length==0)  return -1;
        int ret = A[0];
        for(int i=1; i<A.length; i++)  {
            ret ^= A[i];
        }
        return ret;
    }
    public int singleNumber2nd(int[] A) {
        // logic expression:  A ^ A = 0
        // 0 ^ B = B
        // Array:    AABCCDDDD
        // xor of all numbers
        if(A == null || A.length==0)  return -1;
        if(A.length == 1)  return A[0];
        int ret = 0;
        for(int i : A)  {
            ret ^= i;
        }
        return ret;            
    }
}
