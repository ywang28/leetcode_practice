public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(n<1 || n<k)  return res;
        return combineHelper(1, n, k);
    }
    public ArrayList<ArrayList<Integer>> combineHelper(int start, int end, int k) {
        ArrayList<ArrayList<Integer>> combLists = new ArrayList<ArrayList<Integer>>();
        // base case, all will be selected
        if(k == (end-start+1))  {
            ArrayList<Integer> newList = new ArrayList<Integer>();
            for(int m=start; m<=end; m++)  {
                newList.add(m);
            }
            combLists.add(newList);
            return combLists;
        }
        for(int i=start; i<=end-k+1; i++)  {
            for(ArrayList<Integer> list : combineHelper(i+1,end,k-1))  {
                list.add(0,i);
                combLists.add(list);
            }            
        }
        return combLists;
    }
}
