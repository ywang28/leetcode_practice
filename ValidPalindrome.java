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
    public boolean isPalindrome2nd(String s) {
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
    public boolean isPalindrome3rd(String s) {
        if(s == null)  return false;
        if(s.length() < 2)  return true;
        String lower = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while(i < j)  {
            char front = lower.charAt(i), end = lower.charAt(j);
            if(!Character.isLetterOrDigit(front))  {
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(end))  {
                j--;
                continue;
            }
            if(front != end)  return false;
            i++;
            j--;
        }
        return true;
    }
}
