public class AddBinary {
    public String addBinary(String a, String b) {
        if(a==null || b==null)  return "";
        int lena = a.length(), lenb = b.length();
        int adda = 0, addb = 0, carry = 0;
        if(lena==0)  return b;
        if(lenb==0)  return a;
        StringBuilder ans = new StringBuilder();
        for(int ia = lena-1, ib = lenb-1; ia>=0 || ib>=0; ia--, ib--)  {
            // get corresponding bits if any
            adda = (ia < 0) ? 0 : (a.charAt(ia) - '0');
            addb = (ib < 0) ? 0 : (b.charAt(ib) - '0');
            // invalid binary number
            if(adda < 0 || adda > 1 || addb < 0 || addb > 1)  return "";
            int sum = adda + addb + carry;
            ans.insert(0, sum % 2);
            carry = sum / 2;
        }
        // add highest bit carry
        if(carry == 1)  {
            ans.insert(0,"1");
        }
        return ans.toString();
    }
}
