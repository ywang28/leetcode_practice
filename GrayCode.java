public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(n < 0)  return ret;
        ret.add(0);
        // f(n) = f(n-1) + f(n-1).reverse + Math.pow(2,n-1)
        for(int i=0; i<n; i++)  {
            int offset = 1 << i;
            for(int m = ret.size()-1; m >= 0; m--)  {
                ret.add(ret.get(m) + offset);
            }
        }
        return ret;
    }
}
