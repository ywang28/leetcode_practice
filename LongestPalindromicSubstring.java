public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0)  return s;
        int len = s.length();
        // dp table to record if substring(i,j+1) is palindrom
        boolean[][] isPalindrome = new boolean[len][len];
        // initialize diagonal to be true;
        for(int i=0; i<len; i++)  {
            isPalindrome[i][i] = true;
        }
        // initialize max len of palindrome and its index position
        int maxlen = 1, start = 0, end = 0;
        // fill up table
        for(int i=len-2; i>=0; i--)  {
            for(int j=i+1; j<=len-1; j++)  {
                if(j==i+1)  {
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else  {
                    isPalindrome[i][j] = isPalindrome[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                }
                // longer palindrome found
                if(isPalindrome[i][j] && ((j-i+1) > maxlen))  {
                    maxlen = j-i+1;
                    start = i;
                    end = j;
                }  
            }
        }
        return s.substring(start,end+1);
    }
}
