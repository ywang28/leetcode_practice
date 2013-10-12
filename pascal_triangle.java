public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(numRows<1)  return res;
        if(numRows==1)  {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(1);
            res.add(list);
            return res;
        }
        ArrayList<ArrayList<Integer>> sublists = generate(numRows-1);
        res.addAll(sublists);
        ArrayList<Integer> lastlist = res.get(res.size()-1);
        ArrayList<Integer> newlist = new ArrayList<Integer>();
        newlist.add(1);
        for(int i=0; i<lastlist.size()-1; i++)  {
            newlist.add(lastlist.get(i)+lastlist.get(i+1));
        }
        newlist.add(1);
        res.add(newlist);
        return res;
    }
}
