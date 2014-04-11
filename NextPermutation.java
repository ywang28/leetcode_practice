public class NextPermutation {
    public void nextPermutation(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(num==null || num.length<2)  return;
        int len = num.length;
        int i=len-2;
        // after loop, i+1 will be first position with reverse order from end
        while(i>=0 && num[i]>=num[i+1])  {
            i--;
        }
        reverse(num, i+1, len-1);
        // replace next bigger num with num[i]
        if(i>=0)  {
            for(int j=i+1; j<len; j++)  {
                if(num[j]>num[i])  {
                    int tmp = num[i];
                    num[i] = num[j];
                    num[j] = tmp;
                    break;
                }
            }
        }
    }
    public void reverse(int[] num, int start, int end)  {
        if(start==end)  return;
        int mid = start + (end-start)/2;
        for(int i=start; i<=mid; i++)  {
            int tmp = num[i];
            num[i] = num[end];
            num[end] = tmp;
            end--;
        }
    }
}
