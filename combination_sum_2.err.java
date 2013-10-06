public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num==null || num.length==0)  return new ArrayList<ArrayList<Integer>>();
        return combSumHelper(num,0,target);
    }
    public ArrayList<ArrayList<Integer>> combSumHelper(int[] num, int index, int target)  {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(int i=index; i<num.length; i++)  {
            if(num[index]>target)  continue;
            if(num[index]==target)  {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(target);
                res.add(list);
                return res;
            }
            // num[index]<target, find subsequent comb sum recursively
            res.addAll(combSumHelper(num,index+1,target-num[index]));
            // if num[index] is larger number, merge it to end of list
            // otherwise, merge to beginning of sub list
            for(ArrayList<Integer> sublist : res)  {
                insertSort(num[index],sublist);
            }
        }
        return res;
    }
    public void insertSort(int n, ArrayList<Integer> intlist)  {
        if(intlist.isEmpty() || n>=intlist.get(intlist.size()-1))  intlist.add(n);
        int index = 0;
        while(intlist.get(index)<n)  index++;
        intlist.add(index,n);
    }
}
