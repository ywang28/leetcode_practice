import java.util.*;
public class Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> ans = new ArrayList<String>();
        if(strs==null || strs.length==0)  return ans;
        HashMap<String,ArrayList<String>> strMap = new HashMap<String,ArrayList<String>>();
        for(String s : strs)  {
            if(s==null)  continue;
            String sorted = sortString(s);
            if(strMap.get(sorted)==null)  {
                ArrayList<String> strList = new ArrayList<String>();
                strList.add(s);
                strMap.put(sorted,strList);
            }
            else  {
                strMap.get(sorted).add(s);
            }
        }
        // add strings with more than 1 in the list
        for(ArrayList<String> sList: strMap.values())  {
            if(sList.size()>1)  {
                ans.addAll(sList);
            }
        }
        return ans;
    }
    public String sortString(String s)  {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
    public static void main(String[] Args)  {
        Anagrams a = new Anagrams();
        String[] t = new String[]{"abc","bbc","bac","cba"};
        System.out.println("Input:");
        for(String s : t)  {
            System.out.println(s);
        }
        System.out.println("Output:");
        for(String s : a.anagrams(t))  {
            System.out.println(s);
        }
    }
}
