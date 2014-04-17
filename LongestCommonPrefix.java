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
    public String longestCommonPrefix2(String[] strs) {
        if(strs==null || strs.length==0)  return "";
        int len = strs.length;
        return prefixHelper(strs, len, 0);
    }
    public String prefixHelper(String[] strs, int len, int index)  {
        // last string
        if(index==len-1)  return strs[index];
        String follow = prefixHelper(strs, len, index+1);
        int i=0;
        for(; i<follow.length() && i<strs[index].length(); i++)  {
            if(follow.charAt(i) != strs[index].charAt(i))  break;
        }
        return follow.substring(0, i);
    }
}
