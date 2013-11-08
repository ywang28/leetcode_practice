public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        if(strs==null || strs.length==0)  return ans;
        // if only one string, return itself
        if(strs.length==1 && strs[0]!=null)  return strs[0];
        // any null or empty string, return empty string
        for(int j=0; j<strs.length; j++)  {
            if(strs[j]==null || strs[j].length()==0)  return ans;
        }
        for(int i=0; i<strs[0].length(); i++)  {
            for(int j=1; j<strs.length; j++)  {
                // any string is shorter or with different char, common prefix is ended
                if(i>strs[j].length()-1 || (strs[j].charAt(i) != strs[0].charAt(i)))  return ans;
            }
            ans += strs[0].charAt(i);
        }
        return ans;
    }
}
