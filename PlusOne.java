public class PlusOne {
    public int[] plusOne(int[] digits) {
        if(digits==null || digits.length==0)  return null;
        int sum = 0, carry = 1;
        // add up from lowest digit
        for(int i=digits.length-1; i>=0; i--)  {
            sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        // deal with highest bit
        if(carry == 1)  {
            int[] ret = new int[digits.length+1];
            ret[0] = 1;
            return ret;
        }
        return digits;
    }
    public int[] plusOne2(int[] digits) {
        if(digits==null || digits.length==0)  return new int[0];
        int len = digits.length, i;
        int[] calc = Arrays.copyOf(digits, len);
        // find first non 9 digit
        for(i=len-1; i>=0; i--)  {
            if(calc[i]==9)  {
                calc[i] = 0;
            }
            else  {
                calc[i]++;
                break;
            }
        }
        // need one more digit
        if(i<0)  {
            int[] ret = new int[len+1];
            ret[0] = 1;
            return ret;
        }
        else  {
            return calc;
        }
    }
}
