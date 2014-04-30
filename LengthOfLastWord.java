public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s==null || s.length()==0)  return 0;
        int cnt = 0;
        boolean preSpace = true;
        for(int i=0; i<s.length(); i++)  {
            if(s.charAt(i) == ' ')  {
                preSpace = true;
            }
            else  {
                if(preSpace)  {
                    cnt = 1;
                    preSpace = false;
                }
                else  {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public int lengthOfLastWord2(String s) {
        if(s==null || s.length()==0)  return 0;
        int len = s.length(), ret = 0;
        boolean inWord = false;
        for(int i=len-1; i>=0; i--)  {
            if(!inWord)  {
                if(s.charAt(i)!=' ')  {
                    ret++;
                    inWord = true;
                }
            }
            else  {
                if(s.charAt(i)==' ')  {
                    break;
                }
                ret++;
            }
        }
        return ret;
    }
}
