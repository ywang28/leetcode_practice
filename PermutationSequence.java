// pass
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        if(n<1 || n>9)  return "";
        int[] nums = new int[n];
        for(int i=0; i<n; i++)  {
            nums[i] = i+1;
        }
        int total = fact(n), divider = total, index;
        if(k<1 || k>total)  return "";
        // remove off by 1
        k--;
        StringBuilder sb = new StringBuilder();
        for(int i=n; i>=1; i--)  {
            // get number of permutations for i-1 nums
            divider /= i;
            index = k/divider;
            k = k%divider;
            sb.append(nums[index]);
            nums = removeNum(nums, index);
        }
        return sb.toString();
    }
    public int fact(int n)  {
        if(n==1)  return 1;
        return fact(n-1)*n;
    }
    // remove selected number from array
    public int[] removeNum(int[] nums, int index)  {
        int[] ret = new int[nums.length-1];
        for(int i=0, j=0; i<nums.length; i++)  {
            if(i==index)  continue;
            ret[j++] = nums[i];
        }
        return ret;
    }
    public String getPermutation2(int n, int k) {
        if(n<1 || n>9)  return "";
        int fac = getFactorial(n);
        if(k<1 || k>fac)  return "";
        boolean[] used = new boolean[n];
        StringBuilder sb = new StringBuilder();
        k--;
        int divider = fac;
        for(int i=n; i>0; i--)  {
            divider /= i;
            int order = k/divider;
            // fill in first num
            for(int j=0; j<n; j++)  {
                if(used[j])  continue;
                if(order==0)  {
                    used[j] = true;
                    sb.append(j+1);
                    break;
                }
                else  {
                    order--;
                }
            }
            k = k%divider;
        }
        return sb.toString();
    }
    public int getFactorial(int n)  {
        int ret = 1;
        for(int i=2; i<=n; i++)  {
            ret *= i;
        }
        return ret;
    }
}
