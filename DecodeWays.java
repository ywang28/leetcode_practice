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
    public int numDecodings2nd(String s) {
        if(s==null || s.length()==0)  return 0;
        int[] dp = new int[s.length()];
        for(int i=0; i<dp.length; i++)  {
            dp[i] = -1;
        }
        return decodeHelper(s, 0, dp);
    }
    public int decodeHelper(String s, int index, int[] dp)  {
        if(index > s.length()-1)  return 1;
        if(dp[index]!=-1)  return dp[index];
        int curr = s.charAt(index) - '0';
        // invalid char found
        if(curr<1 || curr>9)  {
            dp[index] = 0;
            return 0;
        }
        // last char
        if(index == s.length()-1)   {
            dp[index] = 1;
            return 1;
        }
        int ways = decodeHelper(s, index+1, dp);
        int twoDigit = curr * 10 + (s.charAt(index+1) - '0');
        if(twoDigit>=10 && twoDigit<=26)   {
            ways += decodeHelper(s, index+2, dp);
        }
        dp[index] = ways;
        return ways;
    }
}
