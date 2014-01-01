/**
   一个array of integer，以及一个int，这个int表示一个window的宽度，这个window从array的一开
   始滑动到最后，找出来在滑动的过程中每次window中int的和，
   比如一个array是[1,2,3,4,5]，然后window的宽度是2，那么就输出[3,5,7,9]
*/  
import java.util.ArrayList;

public class WindowSum  {
    public static void main(String[] Args)  {
        WindowSum t = new WindowSum();
        t.test(new int[]{1,2,3}, 0);
        t.test(new int[]{1,2,3}, 1);
        t.test(new int[]{1,2,3,4,7}, 2);
        t.test(new int[]{1,2,3}, 3);
        t.test(new int[]{1,2,3}, 4);
        t.test(new int[]{1,2,3}, -1);
        t.test(new int[]{1}, 6);
        t.test(new int[]{}, 6);
        t.test(null, 6);
    }
    public int[] solve(int[] nums, int window)  {
        if(nums == null || nums.length == 0 || window < 1)  return new int[]{};
        if(window == 1)  return nums;
        int len = nums.length;
        // result array should have len-window+1 elements or 1 at least
        int retLen = Math.max(1, len - window + 1);
        int[] ret = new int[retLen];
        // initialize first num
        int sum = 0;
        for(int j=0; j<window && j<len; j++)  {
            sum += nums[j];
        }
        ret[0] = sum;
        for(int i = 1; i + window - 1 < len; i++)  {
            // slide the window
            ret[i] = ret[i-1] - nums[i-1] + nums[i+window-1];
        }
        return ret;
    }
    public void test(int[] in, int win)  {
        System.out.println("in: " + Formatter.flat(in) + " window: " + win + " output: " + Formatter.flat(solve(in,win)));
    }
}
