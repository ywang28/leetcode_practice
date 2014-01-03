/**
  给一个int N，让输出所有的长度为N的valid string的个数，valid string的
  定义是由A,B,C三种字母组成，并且在这个string中任意连续的三个字母不能包括A,B,C
  三个字母，比如BACCA就不是valid string，因为前三个字母B,A,C包含了这三个字母
*/  
import java.util.ArrayList;

/*
   Number of valid strings with length N is defined as f(N)
   f(N) can be divided into two groups:
   Last two chars are the same:  f(N)1
   Last two chars are different:  f(N)2
   If they are the same, char at N+1 can be any of A, B or C
   If they are different, char at N+1 can be only two cases, discarding the one vialating rule
   So we get:
   f(N+1) = f(N)1 * 3 + f(N)2 * 2
   It's easy to find out:
   f(N+1)1 = f(N)1 + f(N)2
   f(N+1)2 = f(N)1 * 2 + f(N)2 = f(N)1 + f(N+1)1

   We can use 2d dp table to find out solution, but we can also simplify to 1d dp.
   Initialize dp table to:
   dp[1] = f(2)1 = 3
   dp[2] = f(2)2 = 6

   Then repeatedly do:
   dp[n] += dp[n-1]
   dp[n+1] = dp[n-1] + dp[n]

   Final result is:
   f(N) = dp[N-1] + dp[N]
 */

public class ValidString  {
    public static void main(String[] Args)  {
        ValidString t = new ValidString();
        for(int i=0; i<10; i++)  {
            t.test(i);
        }
    }
    public int solve(int n)  {
        if(n < 1)  return 0;

        int[] dp = new int[n+1];
        dp[0] = 3;
        dp[1] = 0;
        for(int i=1; i<n; i++)  {
            dp[i] += dp[i-1];
            dp[i+1] = dp[i-1] + dp[i];
        }
        return dp[n-1] + dp[n];
    }
    public void test(int n)  {
        System.out.println("input " + n + " output " + solve(n));
    }
}
