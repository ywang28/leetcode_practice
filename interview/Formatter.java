/*
   This class converts data into printable format per test requirement
**/
import java.util.ArrayList;

public final class Formatter  {
    public static String flat(String s)  {
        return s;
    }
    public static String flat(int[] in)  {
        String ret = "";
        if(in != null)  {
            for(int n : in)  {
                ret += n + " ";
            }
        }
        return ret.trim();
    }
    public static String flat(int[][] in)  {
        String ret = "";
        if(in != null)  {
            for(int[] n : in)  {
                ret += "\n" + flat(n);
            }
        }
        return ret.replaceAll(" ","\t");
    }
    public static String flat(ArrayList<ArrayList<Integer>> in)  {
        String ret = "";
        if(in != null)  {
            for(ArrayList<Integer> t : in)  {
                ret += "\n" + flatList(t);
            }
        }
        return ret;
    }
    public static String flatList(ArrayList<Integer> in)  {
        String ret = "";
        if(in != null)  {
            for(Integer t : in)  {
                ret += t + " ";
            }
        }
        return "[" + ret.trim() + "]";
    }
}
