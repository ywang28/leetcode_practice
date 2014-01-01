/*
   This class converts data into printable format per test requirement
**/
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
}
