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
}
