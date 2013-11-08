// Output limit exceeded
import java.util.*;
public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if(num==null || num.length<3)  return ans;
        Arrays.sort(num);
        threeSumHelper(num, ans, new ArrayList<Integer>(), 3, 0, 0);
        return ans;
    }
    public void threeSumHelper(int[] num, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> path, int cnt, int index, int target)  {
        // base case, one num match
        if(cnt==1)  {
            for(int i=index; i<num.length; i++)  {
                if(num[i]==target)  {
                    path.add(num[i]);
                    System.out.println("add num " + num[i]);
                    ans.add(new ArrayList<Integer>(path));
                    path.remove(path.size()-1);
                    return;
                }
            }
            return;
        }
        // dfs search
        for(int i=index; i<num.length-cnt+1; i++)  {
            // ignore duplicates
            if(i>index && num[i]==num[index])  continue;
            path.add(num[i]);
            threeSumHelper(num, ans, path, cnt-1, index+1, target-num[i]);
            path.remove(path.size()-1);
        }
    }
    public static void main(String[] Args)  {
        ThreeSum t = new ThreeSum();
        t.threeSum(new int[]{-1,0,1,0});
    }
}
