/**
  给一个array of int，以及一个range (low, high)，找出array中
  所有的continuous subsequence使得这个subsequence的和在range之中
  不能用sort。数字可能是负数
*/  
import java.util.ArrayList;
import java.util.Arrays;

public class RangeSum  {
    public static void main(String[] Args)  {
        RangeSum t = new RangeSum();
        t.test(new int[]{3, 5, -1, 2}, 4, 7);
    }
    // O(N2) sum up sequence in order, if within range, add to result list
    public ArrayList<ArrayList<Integer>> solve(int[] nums, int low, int high)  {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        for(int i=0, len = nums.length; i<len; i++)  {
            int sum = 0;
            for(int j=i; j<len; j++)  {
                sum += nums[j];
                if(sum>=low && sum<=high)  {
                    addSeq(ret, nums, i, j);
                }
            }
        }
        return ret;
    }
    public void addSeq(ArrayList<ArrayList<Integer>> ret, int[] nums, int i, int j)  {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int k=i; k<=j; k++)  {
            list.add(nums[k]);
        }
        ret.add(list);
    }
    public void test(int[] nums, int low, int high)  {
        System.out.println("input " + Formatter.flat(nums) + " range " + low + " " + high);
        System.out.println("output " + Formatter.flat(solve(nums, low, high)));
    }
}
