public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num==null || num.length==0)  return new ArrayList<ArrayList<Integer>>();
        return permuteHelper(num,0);
        
    }
    public ArrayList<ArrayList<Integer>> permuteHelper(int[] num, int index)  {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(index==num.length-1)  {
            ArrayList<Integer> intlist = new ArrayList<Integer>();
            intlist.add(num[index]);
            res.add(intlist);
            return res;
        }
        for(ArrayList<Integer> sublist : permuteHelper(num,index+1))  {
            for(int i=0; i<sublist.size(); i++)  {
                ArrayList<Integer> newlist = new ArrayList<Integer>(sublist);
                newlist.add(i,num[index]);
                res.add(newlist);
            }
            // add to last position
            sublist.add(num[index]);
            res.add(sublist);
        }
        return res;
    }    
    public ArrayList<ArrayList<Integer>> permuteHelper2nd(int[] num, int index)  {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        // base case
        if(index == num.length)  {
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        // insert current number in all possible locations
        for(ArrayList<Integer> sublist : permuteHelper2nd(num,index+1))  {
            for(int i=0; i<=sublist.size(); i++)  {
                ArrayList<Integer> newlist = new ArrayList<Integer>(sublist);
                newlist.add(i, num[index]);
                ret.add(newlist);
            }
        }
        return ret;
    }

    public ArrayList<ArrayList<Integer>> permute3rd(int[] num) {
        return permuteHelper(num, 0);
    }
    public ArrayList<ArrayList<Integer>> permuteHelper(int[] num, int index)  {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(num==null || index==num.length)  {
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        for(ArrayList<Integer> list : permuteHelper(num, index+1))  {
            for(int i=0; i<=list.size(); i++)  {
                ArrayList<Integer> nextList = new ArrayList<Integer>(list);
                nextList.add(i, num[index]);
                ret.add(nextList);
            }
        }
        return ret;
    }
}
