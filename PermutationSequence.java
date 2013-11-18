// Wrong answer
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int fac = fact(n);
        if(k<1 || k>fac)  return "";
        if(n==1)  return "1";
        String ans = "";
        int pre = 0;
        int curr = ( k - 1 ) / ( fac / n ) + 1;
        if(pre != 0 && curr >= pre)  {
            curr++;
        }
        ans += curr;
        ans += getPermutation(n-1, ( k - 1 ) % ( fac / n ) + 1);
        return ans;
    }
    public int fact(int n)  {
        if(n==1)  return 1;
        return n * fact(n-1);
    }
}
