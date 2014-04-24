public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if(candidates==null || candidates.length==0)   return ans;
        Arrays.sort(candidates);
        combSumHelper(candidates, 0, target, ans, new ArrayList<Integer>());
        return ans;
    }
    public void combSumHelper(int[] candidates, int index, int target, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr)  {
        if(target < 0)  return;
        if(target == 0)  {
            ans.add(new ArrayList<Integer>(curr));
            return;
        }
        for(int i=index; i<candidates.length; i++)  {
            if(candidates[i] <= target)  {
                curr.add(candidates[i]);
                combSumHelper(candidates, i, target - candidates[i], ans, curr);
                curr.remove(curr.size()-1);
            }
            else  {
                break;
            }
        }
    }
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(candidates==null || candidates.length==0)  return ret;
        Arrays.sort(candidates);
        combHelper(candidates, target, 0, ret, new ArrayList<Integer>());
        return ret;
    }
    public void combHelper(int[] candidates, int target, int index, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> path)  {
        if(target == 0)  {
            ret.add(new ArrayList<Integer>(path));
            return;
        }
        if(0 > target)  return;
        for(int i=index; i<candidates.length; i++)  {
            path.add(candidates[i]);
            combHelper(candidates, target-candidates[i], i, ret, path);
            path.remove(path.size()-1);
        }
    }
}
