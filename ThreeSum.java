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
    public ArrayList<ArrayList<Integer>> threeSum2nd(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(num==null || num.length<3)  return ret;
        Arrays.sort(num);
        for(int i=0; i<num.length-2; i++)  {
            // first num is positive , exit
            if(num[i]>0)  break;
            // remove duplicates
            if(i>0 && num[i]==num[i-1])  continue;
            int start=i+1, end=num.length-1;
            while(start<end)  {
                int sum = num[i] + num[start] + num[end];
                if(sum==0)  {
                    ArrayList<Integer> curr = new ArrayList<Integer>();
                    curr.add(num[i]);
                    curr.add(num[start]);
                    curr.add(num[end]);
                    ret.add(curr);
                    start++;
                    end--;
                    while(start<num.length-2 && num[start]==num[start-1])  start++;
                    while(end>0 && end<num.length-1 && num[end]==num[end+1])  end--;
                }
                else if(sum<0)  {
                    start++;
                }
                else  {
                    end--;
                }
            }
        }
        return ret;
    }
    public ArrayList<ArrayList<Integer>> threeSum3(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(num==null || num.length<3)  return ret;
        Arrays.sort(num);
        for(int i=0; i<num.length; i++)  {
            // positive num, search is done
            if(num[i]>0)  break;
            // remove duplicates
            if(i>0 && num[i]==num[i-1])  continue;
            int j=i+1, k=num.length-1;
            while(j<k)  {
                // remove duplicates
                if(j>i+1 && num[j]==num[j-1])  {
                    j++;
                    continue;
                }
                int sum = num[j]+num[k]+num[i];
                if(sum==0)  {
                    ArrayList<Integer> curr = new ArrayList<Integer>();
                    curr.add(num[i]);
                    curr.add(num[j]);
                    curr.add(num[k]);
                    ret.add(curr);
                    j++;
                    k--;
                }
                else if(sum>0)  {
                    k--;
                }
                else  {
                    j++;
                }
            }
        }
        return ret;
    }
}
