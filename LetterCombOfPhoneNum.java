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
}
