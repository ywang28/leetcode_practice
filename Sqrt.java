public class Sqrt {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x<0)  return -1;
        if(x==0)  return 0;
        if(x==1)  return 1;
        return findSqrt(0,x,x);
        
    }
    public int findSqrt(int p, int q, int x)  {
        if(p>q-2)  return -1;
        int mid=(p+q)/2;
        if(mid==x/mid)  {
            return mid;
        }
        else if(mid>x/mid)  {
            return findSqrt(p,mid,x);
        }
        else  {
            return findSqrt(mid,q,x);
        }
    }
    public int sqrt2(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        assert(x>=0);
        if(x==0)  return 0;
        if(x==1)  return 1;
        int start = 1, end = x/2, mid = start + (end-start)/2;
        while(start<=end)  {
            mid = start + (end-start)/2;
            if(mid == x/mid)  {
                return mid;
            }
            else if(mid > x/mid)  {
                end = mid-1;
            }
            else  {
                start = mid+1;
            }
        }
        return end;
    }
}
