import java.util.ArrayList;
import java.util.Arrays;

public class Subsets2 {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(num==null || num.length==0)  return ret;
        Arrays.sort(num);
        subsetsHelper(num, 0, ret, new ArrayList<Integer>());
        return ret;
    }
    public void subsetsHelper(int[] num, int index, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> path)  {
        ret.add(new ArrayList<Integer>(path));
        for(int i=index; i<num.length; i++)  {
            // remove duplicates
            if(i>index && num[i]==num[i-1])  continue;
            path.add(num[i]);
            subsetsHelper(num, i+1, ret, path);
            path.remove(path.size()-1);
        }
    }
    public static void main(String[] args)  {
        Subsets2 s = new Subsets2();
        s.subsetsWithDup(new int[]{1,2,3,4,5,6,7,0});
        for(ArrayList<Integer> aa : s.subsetsWithDup(new int[]{1,2,3,4,5,6,7,0}))  {
            for(int n : aa)  {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }    
    public ArrayList<ArrayList<Integer>> subsetsWithDup2nd(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(num!=null)  {
            Arrays.sort(num);
        }
        ret.add(new ArrayList<Integer>());
        subsetHelper2nd(num, 0, ret, new ArrayList<Integer>());
        return ret;
    }
    public void subsetHelper2nd(int[] num, int index, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> path)  {
        if(num==null || index==num.length)  return;
        for(int i=index; i<num.length; i++)  {
            // remove duplicates
            if(i>index && num[i]==num[i-1])  continue;
            path.add(num[i]);
            ret.add(new ArrayList<Integer>(path));
            subsetHelper(num, i+1, ret, path);
            path.remove(path.size()-1);
        }
    }
}
