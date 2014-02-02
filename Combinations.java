public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(n<1 || k<1 || n<k)  return ret;
        combineHelper(n, k, 1, ret, new ArrayList<Integer>());
        return ret;
    }
    public void combineHelper(int n, int k, int curr, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> path)  {
        // one combination found
        if(path.size()==k)  {
            ret.add(new ArrayList<Integer>(path));
            return;
        }
        // DFS search
        for(int i=curr; i<=n; i++)  {
            path.add(i);
            combineHelper(n, k, i+1, ret, path);
            path.remove(path.size()-1);
        }
    }
}
