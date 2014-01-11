public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        assert(divisor!=0);
        // find out max power of 2 in result. dividend < (divisor << x)
        int sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? 1 : -1;
        // get abs value. Take care of possible overflow Math.abs(Integer.MIN_VALUE) by using long
        long divid = Math.abs((long)dividend);
        long divis = Math.abs((long)divisor);
        int maxbit = 0;
        for(; divid >= (divis << maxbit); maxbit++)  ;
        if(maxbit == 0)  return 0;
        maxbit--;
        ArrayList<Integer> quo = new ArrayList<Integer>();
        for(int i=maxbit; i>=0; i--)  {
            long curr = divis << i;
            if(divid >= curr)  {
                quo.add(0,1);
                divid -= curr;
            }
            else  {
                quo.add(0,0);
            }
        }
        int ret = 0;
        for(int i=0; i<quo.size(); i++)  {
            ret += (quo.get(i) == 0) ? 0 : (1 << i);
        }
        return (sign == 1) ? ret : -ret;
    }
}
