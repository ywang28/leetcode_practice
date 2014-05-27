import java.util.*;
public class PascalTriangle2 {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(rowIndex<0)  return ans;
        int[] pascal = new int[rowIndex+1];
        pascal[0] = 1;
        for(int row=0; row<rowIndex; row++)  {
            for(int i=rowIndex; i>0; i--)  {
                pascal[i] += pascal[i-1];
            }
        }
        for(int n : pascal)  {
            ans.add(n);
        }
        return ans;
    }
    public List<Integer> getRow2nd(int rowIndex) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(rowIndex < 0)  return ret;
        ret.add(1);
        for(int k = 1; k <= rowIndex; k++)  {
            for(int i = k-1; i > 0; i--)  {
                ret.set(i, ret.get(i) + ret.get(i-1));
            }
            ret.add(1);
        }
        return ret;
    }
}
