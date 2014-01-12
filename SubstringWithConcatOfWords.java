public class SubstringWithConcatWithWords {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(S==null || S.length()==0 || L==null || L.length==0)  return ret;
        // records if each word in L is used
        HashMap<String,Integer> map = initHash(L);
        int wordLen = L[0].length(), wordCnt = L.length, totalLen = wordLen * wordCnt, sLen = S.length();
        // S is too short
        if(sLen < totalLen)  return ret;
        for(int i=0; i<=sLen - totalLen; i++)  {
            HashMap<String,Integer> mapCopy = new HashMap<String,Integer>(map);
            boolean valid = true;
            for(int j=0; j<wordCnt; j++)  {
                String curr = S.substring(i+j*wordLen, i+(j+1)*wordLen);
                // word not in the list or word is already used. Assum no duplicate words in L
                if(!mapCopy.containsKey(curr) || mapCopy.get(curr)==0)  {
                    valid = false;
                    break;
                }
                mapCopy.put(curr,mapCopy.get(curr)-1);
            }
            if(valid)  ret.add(i);
        }
        return ret;
    }
    public HashMap<String,Integer> initHash(String[] L)  {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(String s : L)  {
            if(map.containsKey(s))  {
                map.put(s, map.get(s)+1);
            }
            else  {
                map.put(s, 1);
            }
        }
        return map;
    }
}
