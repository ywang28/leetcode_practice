public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)  return false;
        // single digit is always palindrome
        if(x<10)  return true;
        int highBase = 10;
        // find out highest digit
        while(x/highBase > 9)  {
            highBase *=10;
        }
        while(highBase > 1)  {
            int highDigit = x/highBase;
            int lowDigit = x%10;
            if(highDigit != lowDigit)  return false;
            // remove highest and lowest digit from x
            x %= highBase;
            x /= 10;
            // check inner number
            highBase /= 100;
        }
        return true;
    }
}
