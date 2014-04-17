public class LetterCombOfPhoneNum {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> ans = new ArrayList<String>();
        if(digits==null || digits.length()==0)  {
            ans.add("");
            return  ans;
        }
        String[] dict = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        return getCombinations(digits, digits.length()-1, dict);
    }
    public ArrayList<String> getCombinations(String digits, int index, String[] dict)  {
        ArrayList<String> comb = new ArrayList<String>();
        int num = digits.charAt(index) - '0';
        if(index==0)  {
            for(int i=0; i<dict[num].length(); i++)  {
                comb.add(""+dict[num].charAt(i));
            }
            return comb;
        }
        for(String s : getCombinations(digits, index-1, dict))  {
            for(int i=0; i<dict[num].length(); i++)  {
                comb.add(s + dict[num].charAt(i));
            }
        }
        return comb;
    }
    public ArrayList<String> letterCombinations2(String digits) {
        if(digits==null)  {
            ArrayList<String> ret = new ArrayList<String>();
            ret.add("");
            return ret;
        }
        String[] dict = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        return combHelper(digits, digits.length()-1, dict);
    }
    public ArrayList<String> combHelper(String digits, int index, String[] dict)  {
        ArrayList<String> ret = new ArrayList<String>();
        // base case
        if(digits==null || index==-1)  {
            ret.add("");
            return ret;
        }
        int num = digits.charAt(index) - '0';
        // error
        if(num<2 || num>9)  return ret;
        for(String s : combHelper(digits, index-1, dict))  {
            for(char c : dict[num].toCharArray())  {
                ret.add(s + c);
            }
        }
        return ret;
    }
}
