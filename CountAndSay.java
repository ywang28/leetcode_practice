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
    public String countAndSay2(int n) {
        StringBuilder sb = new StringBuilder("1"), next = new StringBuilder();
        char last = 'x';
        int cnt = 1;
        for(int k=1; k<n; k++)  {
            for(int i=0; i<sb.length(); i++)  {
                if(i==0)  {
                    last = sb.charAt(i);
                }
                else if(last == sb.charAt(i))  {
                    cnt++;
                }
                else  {
                    next.append(cnt + "" + last);
                    last = sb.charAt(i);
                    cnt = 1;
                }
            }
            // add last group of chars
            next.append(cnt + "" + last);
            // swap two strings
            StringBuilder tmp = sb;
            sb = next;
            next = tmp;
            next.setLength(0);
            cnt = 1;
        }
        return sb.toString();
    }
}
