// 2nd solution for roman to integer
public class RomanToIntegerNew {
    public int romanToInt(String s) {
        if(s==null || s.length()==0)  return 0;
        int ans = 0;
        HashMap<String,Integer> romanTable = buildRomanTable();
        int i;
        for(i=0; i<s.length()-1; i++)  {
            String ss = ""+s.charAt(i)+s.charAt(i+1);
            if(romanTable.containsKey(ss))  {
                ans += romanTable.get(ss);
                i++;
            }
            else  {
                ans += romanTable.get(s.substring(i,i+1));
            }
        }
        // if last one is not 2-chars num, add it up also
        if(i==s.length()-1)  {
            ans += romanTable.get(s.substring(i));            
        }
        return ans;
    }
    public HashMap<String,Integer> buildRomanTable()  {
        HashMap<String,Integer> t = new HashMap<String,Integer>();
        t.put("I",1);
        t.put("V",5);
        t.put("X",10);
        t.put("L",50);
        t.put("C",100);
        t.put("D",500);
        t.put("M",1000);
        t.put("IV",4);
        t.put("IX",9);
        t.put("CD",400);
        t.put("CM",900);
        t.put("XL",40);
        t.put("XC",90);
        return t;
    }
}
