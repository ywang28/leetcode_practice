// Wrong answer
public class NQueens {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> ret = new ArrayList<String[]>();
        if(n == 1)  {
            ret.add(new String[]{"Q"});
            return ret;
        }
        // no solution for n < 3 except 1
        if(n < 3)  return ret;
        // table to record col number + 1 used for corresponding row
        int[] rows = new int[n];
        // n*n matrix has 4*n -2 diagonals. records if any confilict in diagonal and col
        boolean[] cols = new boolean[n];
        boolean[] diags1 = new boolean[2*n-2];
        boolean[] diags2 = new boolean[2*n-2];
        helper(n, 0, rows, cols, diags1, diags2, ret);
        return ret;
    }
    public void helper(int n, int index, int[] rows, boolean[] cols, boolean[] diags1, boolean[] diags2, ArrayList<String[]> ret)  {
        // valid solution found
        if(n==index)  {
            String[] strs = new String[n];
            for(int i=0; i<n; i++)  {
                String curr = "";
                for(int j=0; j<n; j++)  {
                    curr += (rows[i] == j+1) ? "Q" : ".";
                }
                strs[i] = curr;
            }
            ret.add(strs);
            return;
        }
        for(int i=index; i<n; i++)  {
            for(int j=0; j<n; j++)  {
                // slash diagonal
                int dia1 = i+j;
                // backslash diagonal
                int dia2 = i+n-1-j;
                // confilicts found
                if(cols[j] || diags1[dia1] || diags2[dia2])  continue;
                // DFS
                rows[index] = j+1;
                cols[j] = true;
                diags1[dia1] = true;
                diags2[dia2] = true;
                helper(n, index+1, rows, cols, diags1, diags2, ret);
                rows[index] = 0;
                cols[j] = false;
                diags1[dia1] = false;
                diags2[dia2] = false;
            }
        }
    }
}
