public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num==null || num.length<3)  return Integer.MIN_VALUE;
        if(num.length==3)  return num[0]+num[1]+num[2];
        return closestSum(num,0,target,3);
    }
    public int closestSum(int[] num,int index,int target,int k)  {
        int sum = 0;
        // base case: 1sum closest
        if(k==1)  {
            sum = num[index];
            while(++index < num.length)  {
                if(Math.abs(num[index]-target)<Math.abs(sum-target))  {
                    sum = num[index];
                }
            }
            return sum;
        }
        sum = num[index] + closestSum(num,index+1,target-num[index],k-1);
        while(++index <= num.length-k)  {
            int nextsum = num[index]+closestSum(num,index+1,target-num[index],k-1);
            if(Math.abs(nextsum-target)<Math.abs(sum-target))  {
                sum = nextsum;
            }
        }
        return sum;
    }
    public int threeSumClosest2nd(int[] num, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(num==null || num.length<3)  return -1;
        int diff = Integer.MAX_VALUE, ret = 0;
        Arrays.sort(num);
        for(int i=0; i<num.length-2; i++)  {
            if(i>0 && num[i]==num[i-1])  continue;
            int start = i+1, end = num.length-1;
            while(start < end)  {
                int sum = num[i] + num[start] + num[end];
                if(Math.abs(sum - target) < diff)  {
                    diff = Math.abs(sum - target);
                    ret = sum;
                }
                if(sum < target)  {
                    start++;
                }
                else   {
                    end--;
                }
            }
        }
        return ret;
    }
}
