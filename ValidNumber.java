public class ValidNumber {
    public boolean isNumber(String s) {
        if(s==null || s.length()==0)  return false;
        int i=0;
        int digitPointCnt = 0;
        while(i<s.length() && s.charAt(i)==' ')  i++;  // ignore prevailing spaces
        if(i<s.length() && (s.charAt(i)=='-' || s.charAt(i)=='+'))  i++;  // - or + sign
        if(i<s.length() && s.charAt(i)=='.') {
            i++;   // allow starting digit point
            digitPointCnt++;
        }
        if(isNonNum(s,i))  return false;  // start with non-num
        i = nextNonNum(s,i);  
        if(i==s.length())  return true;  // all numerics
        if(s.charAt(i)==' ')  return allSpaces(s,i);  // check trailing spaces
        if(s.charAt(i)=='.')  {
            digitPointCnt++;
            if(digitPointCnt>1)  return false;   // two digit points are invalid
            i++;
            if(i==s.length())  return true;   // allow trailing digit point
            if(s.charAt(i)==' ')  return allSpaces(s,i);
            if(s.charAt(i)=='e'||s.charAt(i)=='E')  return validExp(s,i+1);  // allow .e
            if(isNonNum(s,i))  return false;  // digit point followed by non-num
            i = nextNonNum(s,i); 
            if(i==s.length())  return true;  // all nums
            if(s.charAt(i)==' ')  return allSpaces(s,i);  // check trailing spaces
            if(s.charAt(i)=='e'||s.charAt(i)=='E')  return validExp(s,i+1);
            return false;  // any other characters are invalid
        }
        else if(s.charAt(i)=='e'||s.charAt(i)=='E')  {
            return validExp(s,i+1);
        }
        return false;
    }
    public boolean isNonNum(String s, int i)  {
        if(i>=s.length())  return true;
        return s.charAt(i)<'0' || s.charAt(i)>'9';
    }
    // find next non-num position
    public int nextNonNum(String s, int i)  {
        while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9')  i++;
        return i;
    }
    // check trailing spaces
    public boolean allSpaces(String s, int i)  {
        while(i<s.length() && s.charAt(i)==' ')  i++;
        if(i==s.length())  return true; 
        return false;        
    }
    // check valid exponential num
    public boolean validExp(String s, int i)  {
        if(i<s.length() && (s.charAt(i)=='-' || s.charAt(i)=='+'))  i++;
        if(isNonNum(s,i))  return false;
        i = nextNonNum(s,i);
        if(i==s.length())  return true;  // all numerics
        if(s.charAt(i)==' ')  return allSpaces(s,i);  // check trailing spaces
        return false;
    }
}
