public class StringToInteger {
    public int atoi(String str) {
        if(str==null || str.length()==0)  return 0;
        int len = str.length();
        int ans = 0, start = 0, sign = 1, digit = 0;
        // find first non space char
        while(start < len && str.charAt(start) == ' ')  {
            start++;
        }
        // all spaces
        if(start==len)  return ans;
        if(str.charAt(start)=='+' || str.charAt(start)=='-')  {
            sign = (str.charAt(start) == '-') ? -1 : 1;
            start++;
        }
        // no valid digits remaining
        if(start==len || !Character.isDigit(str.charAt(start)))  return ans;
        while(start < len && Character.isDigit(str.charAt(start)))  {
            digit++;
            // deal with overflow problem
            if(digit==10)  {
                if(sign==1)  {
                    ans = (int)Math.min((long)Integer.MAX_VALUE, ((long)ans * 10 + (long)(str.charAt(start)-'0')));
                }
                else  {
                    ans = (int)Math.max((long)Integer.MIN_VALUE, -((long)ans * 10 + (long)(str.charAt(start)-'0')));                    
                }
                // overflow
                if(ans==Integer.MAX_VALUE || ans==Integer.MIN_VALUE)  return ans;
                // get abs value
                ans = sign * ans;
                start++;
                continue;
            }
            if(digit==11)  return (sign==1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            ans = ans * 10 + (str.charAt(start)-'0');
            start++;
        }
        return sign * ans;
    }
}
