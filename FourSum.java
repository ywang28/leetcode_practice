public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(num==null || num.length<4) return ret;
        Arrays.sort(num);
        int len = num.length;
        for(int i=0; i<len-3; i++)  {
            // remove duplicates
            if(i>0 && num[i]==num[i-1])  continue;
            for(int j=i+1; j<len-2; j++)  {
                // remove duplicates
                if(j>i+1 && num[j]==num[j-1])  continue;
                int m=j+1, n=len-1, currSum=num[i]+num[j];
                while(m < n)  {
                    int tmpSum = currSum + num[m] + num[n];
                    if(tmpSum > target)  {
                        n--;
                    }
                    else if(tmpSum < target)  {
                        m++;
                    }
                    else  {
                        ArrayList<Integer> curr = new ArrayList<Integer>();
                        curr.add(num[i]);
                        curr.add(num[j]);
                        curr.add(num[m]);
                        curr.add(num[n]);
                        ret.add(curr);
                        m++;
                        n--;
                        // remove duplicates
                        while(m<len-1 && num[m]==num[m-1])  m++;
                        while(n>2 && num[n]==num[n+1])  n--;
                    }
                }
            }
        }
        return ret;
    }
}
