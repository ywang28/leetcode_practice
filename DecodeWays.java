public class DecodeWays {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s==null || s.length()==0 || s.charAt(0)=='0')  return 0;
        char[] words = s.toCharArray();
        // DP array to record nums of decodings at each index
        int[] records = new int[words.length];
        records[0] = 1;
        for(int i=1; i<words.length; i++)  {
            records[i] = -1;
        }
        return findDecodeWays(records,words,words.length-1);
    }
    public int findDecodeWays(int[] records, char[] words, int index)  {
        if(index<0)  return 1;
        if(records[index]!=-1)  return records[index];
        int ways = (words[index]=='0') ? 0 : findDecodeWays(records,words,index-1);
        int letter = (words[index-1]-'0')*10+(words[index]-'0');
        // valid 2 digit case
        if(letter>=10 && letter<=26)  {
            ways += findDecodeWays(records,words,index-2);
        }
        records[index] = ways;
        return ways;
    }
}
