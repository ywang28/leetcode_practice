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
}
