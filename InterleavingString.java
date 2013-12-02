// wrong answer
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3 == null)  return false;
        if(s1 == null && s2 == null)  return s3.length() == 0;
        if(s1 == null || s1.length() == 0)  return s3.equals(s2);
        if(s2 == null || s2.length() == 0)  return s3.equals(s1);
        if(s3.length() != s1.length() + s2.length())  return false;
        int curr = 0;
        
        // find first position with different char in s1 and s3
        for(curr = 0; curr < s1.length() && s1.charAt(curr) == s3.charAt(curr); curr++)  ;
        if(curr > 0 && isInterleave(s1.substring(curr), s2, s3.substring(curr)))  return true; 
        // find first position with different char in s2 and s3
        for(curr = 0; curr < s2.length() && s2.charAt(curr) == s3.charAt(curr); curr++)  ;
        if(curr > 0 && isInterleave(s1, s2.substring(curr), s3.substring(curr)))  return true; 
        return false;
    }
    public static void main(String[] Args)  {
        InterleavingString i = new InterleavingString();
        // expected "true"
        System.out.println(i.isInterleave("aabcc","dbbca","aadbcbbcac"));
    }
}
