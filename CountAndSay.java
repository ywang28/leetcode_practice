public class CountAndSay {
    public String countAndSay(int n) {
        if(n<1)  return "";
        StringBuilder ans = new StringBuilder().append("1");
        StringBuilder buf = new StringBuilder();
        for(int i=1; i<n; i++)  {
            int next = 1, cnt = 1;
            for(; next<ans.length(); next++)  {
                if(next>0 && ans.charAt(next)==ans.charAt(next-1))  {
                    cnt++;
                }
                else   {
                    buf.append(cnt);
                    buf.append(ans.charAt(next-1));
                    cnt = 1;
                }
            }
            // append last group
            buf.append(cnt);
            buf.append(ans.charAt(next-1));
            // exchange buf and ans
            StringBuilder tmp = ans;
            ans = buf;
            buf = tmp;
            // clear buffer
            buf.delete(0,buf.length());
        }
        return ans.toString();
    }
}
