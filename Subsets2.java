// wrong answer
public class Subsets2 {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(num==null || num.length==0)  return ret;
        Arrays.sort(num);
        subsetsHelper(num, 0, new ArrayList<Integer>(), ret);
        ret.add(new ArrayList<Integer>());
        return ret;
    }
    public void subsetsHelper(int[] num, int index, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ret)  {
        // DFS search
        for(int i=index; i<num.length; i++)  {
            // repeated num found
            if(i>index && num[i]==num[i-1])  continue;
            curr.add(num[i]);
            ret.add(new ArrayList<Integer>(curr));
            subsetsHelper(num, index+1, curr, ret);
            curr.remove(curr.size()-1);
        }
    }
}
