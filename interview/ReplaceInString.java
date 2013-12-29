/**
  电面只有一轮，出了一个之前版上出现过的题，一个string由0，1和？组成，并且？可
  以被替换成0或者1，让输出所有的把？替换之后不同的string，比如1？0把？替换之后
  能够生成110和100
*/  
import java.util.ArrayList;

public class ReplaceInString  {
    public static void main(String[] Args)  {
        ReplaceInString t = new ReplaceInString();
        ArrayList<String> ans = t.solve("00?10??01");
        System.out.println("00?10??01");
        for(String s : ans)  {
            System.out.println(s);
        }
    }
    // O(n) + O(pow(2,m) * m).  n : string length, m : num of question marks
    public ArrayList<String> solve(String s)  {
        ArrayList<String> ans = new ArrayList<String>();
        // record locations of question marks
        ArrayList<Integer> qMarks = new ArrayList<Integer>();
        for(int i=0; i<s.length(); i++)  {
            if(s.charAt(i) == '?')  qMarks.add(i);
        }
        int numOfMarks = qMarks.size();
        // count from 000 to 111 
        for(int i=0; i<(1 << numOfMarks); i++)  {
            StringBuilder sb = new StringBuilder(s);
            // set question marks corresponding to the bit value
            for(int j=0; j<numOfMarks; j++)  {
                sb.setCharAt(qMarks.get(j), (char)(((i >> j) & 1) + '0'));
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
