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
}
