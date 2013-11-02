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
}
