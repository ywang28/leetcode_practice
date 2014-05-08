public class Subsets {
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
    public ArrayList<ArrayList<Integer>> subsets2(int[] S) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(S==null)  return ret;
        Arrays.sort(S);
        int len = S.length, max = 1<<len;
        // count from 0 to pow(2,len) - 1. Each bit represent if certain num is selected
        for(int i=0; i<max; i++)  {
            ArrayList<Integer> curr = new ArrayList<Integer>();
            // get each bit of i and add corresponding num
            for(int j=i, index=0; j>0; j>>=1, index++)  {
                if((j & 1) == 1)  {
                    curr.add(S[index]);
                }
            }
            ret.add(curr);
        }
        return ret;
    }
    public ArrayList<ArrayList<Integer>> subsets3(int[] S) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ret.add(new ArrayList<Integer>());
        if(S==null || S.length==0)  return ret;
        Arrays.sort(S);
        for(int i=0; i<S.length; i++)  {
            ArrayList<ArrayList<Integer>> newList = new ArrayList<ArrayList<Integer>>();
            newList.addAll(ret);
            for(ArrayList<Integer> sub : ret)  {
                ArrayList<Integer> curr = new ArrayList<Integer>(sub);
                curr.add(S[i]);
                newList.add(curr);
            }
            ret = newList;
        }
        return ret;
    }
}
