public class ReverseInteger {
    public int reverse(int x) {
        int ans = 0;
        while(x!=0)  {
            ans *= 10;
            ans += x%10;
            x = x/10;
        }
        return ans;
    }
}
