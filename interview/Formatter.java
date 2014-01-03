/*
   This class converts data into printable format per test requirement
**/
import java.util.ArrayList;

public final class Formatter  {
    public static void puts(String s)  {
        System.out.println(s);
    }
    public static String flat(int[] in)  {
        String ret = "";
        if(in != null)  {
            for(int n : in)  {
                ret += n + " ";
            }
        }
        return ret;
    }
    public static String flat(ArrayList<ArrayList<Integer>> in)  {
        String ret = "";
        if(in != null)  {
            for(ArrayList<Integer> t : in)  {
                ret += "[" + flatList(t) + "]" + ",";
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
        return ret;
    }
}
