// wrong answer . Need to remove duplicates
import java.util.*;
public class CombinationSum2 {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if(num==null || num.length==0 || target<=0)  return ans;
        Arrays.sort(num);
        combSumHelper(num, ans, new ArrayList<Integer>(), 0, target);
        return ans;
    }
    public void combSumHelper(int[] num, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> current, int index, int target)  {
        if(target==0)  {
            ans.add(new ArrayList<Integer>(current));
            return;
        }
        if(index>=num.length || num[index]>target)   return;
        for(int i=index; i<num.length; i++)  {
            if(i>index && num[i]==num[i-1])  continue;
            current.add(num[i]);
            combSumHelper(num, ans, current, i+1, target-num[i]);
            current.remove(current.size()-1);
        }
    }
    public static void main(String[] Args)  {
        CombinationSum2 c = new CombinationSum2();
        int[] t = {1};
        c.combinationSum2(t,1);
    }
}
