// wrong answer
public class IsScramble {
    public boolean isScramble(String s1, String s2) {
        if(s1==null || s2==null)  return false;
        if(s1.length()!=s2.length())  return false;
        if(s1.length()==0)  return true;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        s1 = new String(c1);
        s2 = new String(c2);
        return s1.equals(s2);
    }
}
