public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(S==null || S.length==0)  return res;
        return subsetsHelper(S,0,S.length-1);
    }
    public ArrayList<ArrayList<Integer>> subsetsHelper(int[] S, int start, int end)  {
        ArrayList<ArrayList<Integer>> sublists = new ArrayList<ArrayList<Integer>>();
        if(start>end)  {
            sublists.add(new ArrayList<Integer>());
            return sublists;
        }
        ArrayList<ArrayList<Integer>> nextlists = subsetsHelper(S,start+1,end);
        sublists.addAll(nextlists);
        for(ArrayList<Integer> list: nextlists)  {
            ArrayList<Integer> newlist = (ArrayList<Integer>)list.clone();
            int i=0;
            while(i<newlist.size() && S[start]>newlist.get(i))  {
              i++;
            }
            newlist.add(i,S[start]);
            sublists.add(newlist);
        }
        return sublists;
    }
}
