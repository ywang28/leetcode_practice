public class PalindromeNumber {
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
    public boolean isPalindrome2(int x) {
        if(x<0)  return false;
        if(x<10)  return true;
        int digits = 0, y = x;
        while(y>0)  {
            y /= 10;
            digits++;
        }
        int div1 = (int)Math.pow(10,digits-1), div2 = 10;
        while(div1 >= div2)  {
            int msb  = x/div1, lsb = x%div2;
            if(msb != lsb)  return false;
            x %= div1;
            x /= div2;
            div1 /= 100;
        }
        return true;
    }
}
