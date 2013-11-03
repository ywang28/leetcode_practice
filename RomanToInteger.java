// first version
public class RomanToInteger {
    public int romanToInt(String s) {
        if(s==null || s.length()==0)  return 0;
        int ans = 0;
        for(int i=0; i<s.length(); i++)  {
            int current = getBase(s.charAt(i));
            if(current==-1)  return -1;
            int factor = getFactor(s,i);
            if(factor > 1)  {
                current *= factor;
                i++;
            }
            ans += current;
        }
        return ans;
    }
    // get base value
    public int getBase(char c)  {
        switch(c)  {
            case 'I':  return 1;
            case 'V':  return 5;
            case 'X':  return 10;
            case 'L':  return 50;
            case 'C':  return 100;
            case 'D':  return 500;
            case 'M':  return 1000;
            default:   return -1;
        }
    }
    // get factor for 40, 90, etc
    public int getFactor(String s, int i)  {
        if(i<s.length()-1)  {
            char c = s.charAt(i);
            char n = s.charAt(i+1);
            if((c=='I' && n=='V') || (c=='C' && n=='D') || (c=='X' && n=='L'))  {
                return 4;
            }
            else if((c=='I' && n=='X') || (c=='C' && n=='M') || (c=='X' && n=='C'))  {
                return 9;
            }
        }
        return 1;
    }
}
