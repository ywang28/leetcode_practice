// 2nd pass!
public class RestoreIPAddress {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> ans = new ArrayList<String>();
        if(s==null || s.length() < 4)  return ans;
        char[] addr = s.toCharArray();
        // record if 2 digits before plus current digit is valid IP num
        boolean[] isValid = checkIP(addr);
        restoreHelper(addr, ans, 0, 1, 1, new StringBuilder(), isValid);
        return ans;
    }
    public boolean[] checkIP(char[] addr)  {
        boolean[] isValid = new boolean[addr.length];
        // digits less than 3 don't need check
        for(int i=2; i<addr.length; i++)  {
            isValid[i] = ((addr[i-2] - '0') * 100 + (addr[i-1] - '0') * 10 + (addr[i] - '0')) < 256;
        }
        return isValid;
    }
    public void restoreHelper(char[] addr, ArrayList<String> ans, int index, int digits, int cnt, StringBuilder sb, boolean[] isValid)  {
        // more than 4 divisions
        if(cnt > 4)  return;
        // last digit is added
        if(index == addr.length)  {
            ans.add(new String(sb));
            return;
        }
        // check invalid 00s
        if(addr[index] == 0)  {
            if((index == 1 && addr[0] == '0')
                || (index > 2 && addr[index-1] == '0' && addr[index-2] == '.'))
                return;
        }
        // DFS search
        for(int i=digits; i<=3; i++)  {
            if(i != 3 || isValid[index])  {
                sb.append(addr[index]);
                sb.append('.');
                restoreHelper(addr, ans, index+1, digits+1, cnt+1, sb, isValid);
                sb.setLength(sb.length()-1);
                sb.setLength(sb.length()-1);
            }
        }
    }
    public ArrayList<String> restoreIpAddresses2nd(String s) {
        ArrayList<String> ret = new ArrayList<String>();
        if(s==null || s.length()<4)  return ret;
        restoreHelper2nd(s, 0, 4, ret, new StringBuilder());
        return ret;
    }
    // index:  index of string.  rem:  remaining IP sections
    private void restoreHelper2nd(String s, int index, int rem, ArrayList<String> ret, StringBuilder sb)  {
        if(rem==0)  {
            if(index >= s.length())  {
                // remove last dot
                String ss = sb.toString();
                ret.add(ss.substring(0,ss.length()-1));
                return;
            }
            else  {
                return;
            }
        }
        int slen = s.length();
        for(int len = 1; len <= 3 && index + len <= slen; len++)  {
            String sub = s.substring(index, index+len);
            if(isValidIP(sub))  {
                sb.append(sub + '.');
                restoreHelper(s, index+len, rem-1, ret, sb);
                sb.delete(sb.length()-len-1, sb.length());
            }
        }
    }
    private boolean isValidIP(String s)  {
        if(s==null || s.length()==0 || s.length()>3)  return false;
        for(int i=0; i<s.length(); i++)  {
            if(!Character.isDigit(s.charAt(i)))  return false;
        }
        // 00, 01 etc also invalid
        if(s.charAt(0)=='0' && s.length()>1)  return false;
        int num = Integer.parseInt(s);
        return num>=0 && num<=255;
    }
}
