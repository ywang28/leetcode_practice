public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        if(numbers==null || numbers.length<2)  return ans;
        for(int i=0; i<numbers.length-1; i++)  {
            if(numbers[i] >= target)  continue;
            for(int j=i+1; j<numbers.length; j++)  {
                if(numbers[i] + numbers[j] == target)  {
                    ans[0] = i+1;
                    ans[1] = j+1;
                    return ans;
                }
            }
        }
        return ans;
    }
}
