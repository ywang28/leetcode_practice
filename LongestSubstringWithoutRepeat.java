public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)  return 0;
        if(s.length()==1)  return 1;
        // record last position of each chars in the string. counting from 1
        int[] charTable = new int[256];
        int strLength = 1;
        // earliest start position w/o repeating chars
        int start = 0;
        for(int i=0; i<s.length(); i++)  {
            // repeated char is found in current range
            if(charTable[s.charAt(i)] != 0 && charTable[s.charAt(i)] >= start)  {
                // update max length
                strLength = Math.max(strLength, i-start);
                // change start point to last position
                start = charTable[s.charAt(i)];
            }
            // record location of each char in the table
            charTable[s.charAt(i)] = i+1;
        }
        // handle the last character
        strLength = Math.max(strLength, s.length()-start);
        return strLength;
    }
    public static void main(String[] Args)  {
        LongestSubstringWithoutRepeat l = new LongestSubstringWithoutRepeat();
        // expect output 12
        System.out.println(l.lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
    }
}
