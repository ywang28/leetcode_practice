public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0)  return true;
        int start = -1;
        int end = s.length();
        while(++start <= --end)  {
            while(start<s.length() && !Character.isLetterOrDigit(s.charAt(start)))  start++;
            while(end>=0 && !Character.isLetterOrDigit(s.charAt(end)))  end--;
            if(start>end)  return true;
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)))  return false;
        }
        return true;
    }
    public boolean isPalindrome(String s) {
        if(s==null || s.length()==0)  return true;
        int i=0, j=s.length()-1;
        String s2 = s.toLowerCase();
        while(i<=j)  {
            if(!Character.isLetterOrDigit(s2.charAt(i)))  {
                i++;
            }
            else if(!Character.isLetterOrDigit(s2.charAt(j)))  {
                j--;
            }
            else if(s2.charAt(i)!=s2.charAt(j))  {
                return false;
            }
            else  {
                i++;
                j--;
            }
        }
        return true;
    }
}
