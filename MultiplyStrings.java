public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if(num1==null || num1.length()==0)  return num2;
        if(num2==null || num2.length()==0)  return num1;
        int len1 = num1.length(), len2 = num2.length();
        int[] ans = new int[len1+len2];
        for(int i = len1-1; i >= 0; i--)  {
            for(int j = len2-1; j>=0; j--)  {
                int cal = ans[i+j+1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                ans[i+j+1] = cal%10;
                ans[i+j] += cal/10;
            }
        }
        int start = 0;
        while(start < ans.length-1 && ans[start]==0)  start++;
        StringBuilder s = new StringBuilder();
        for(int i = start; i<ans.length; i++)  {
            s.append(ans[i]);
        }
        return s.toString();
    }
    public String multiply2(String num1, String num2) {
        if(num1==null || num2==null)  return "";
        if(num1.length()==0)  return num2;
        if(num2.length()==0)  return num1;
        if(num1.equals("0") || num2.equals("0"))  return "0";
        int len1 = num1.length(), len2 = num2.length();
        int[] res = new int[len1+len2];
        for(int i=len1-1; i>=0; i--)  {
            int n1 = num1.charAt(i) - '0';
            for(int j=len2-1; j>=0; j--)  {
                int n2 = num2.charAt(j) - '0';
                int mul = n1 * n2 + res[i+j+1];
                res[i+j+1] = mul % 10;
                res[i+j] += mul / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        // remove leading 0s
        int start = 0;
        while(start < len1+len2 && res[start]==0)  {
            start++;
        }
        for(int i=start; i<len1+len2; i++)  {
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
