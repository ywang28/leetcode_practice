// wrong answer
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m<1 || n<1)  return 0;
        if(m==1 || n==1)  return 1;
        // get C((m+n-2)(m-1)
        int num = Math.min(m,n);
        int a = 1, b = 1;
        for(int i=1; i<num; i++)  {
            a *= (m + n - 1 - i);
            b *= i;
        }
        return a/b;
    }
}
