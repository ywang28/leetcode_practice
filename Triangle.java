public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle==null || triangle.size()==0 || triangle.get(0)==null || triangle.get(0).size()==0)  return -1;
        if(triangle.size()==1)  return triangle.get(0).get(0);
        // run in place and bubble up. calculate min path for each level
        for(int i=triangle.size()-2; i>=0; i--)  {
            ArrayList<Integer> curr = triangle.get(i);
            ArrayList<Integer> next = triangle.get(i+1);
            for(int j=0; j<curr.size(); j++)  {
                curr.set(j, curr.get(j) + Math.min(next.get(j), next.get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
