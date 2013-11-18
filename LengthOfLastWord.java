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
}
