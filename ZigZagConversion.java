public class ZigZagConversion {
    public static String convert(String s, int nRows) {
        if(s==null || nRows < 2 || s.length()<=nRows)  return s;
        StringBuilder[] buckets = new StringBuilder[nRows];
        // initialize to empty strings
        for(int i=0; i<nRows; i++)  {
            buckets[i] = new StringBuilder();
        }
        // select different buckets in zigzag pattern
        for(int i=0, sel=0, step=1; i<s.length(); i++, sel+=step)  {
            buckets[sel].append(s.charAt(i));
            step = (sel==0) ? 1 : ((sel==nRows-1) ? -1 : step);
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<nRows; i++)  {
            ans.append(buckets[i]);
        }
        return ans.toString();
    }
    public static void main(String[] Args)  {
        System.out.println(convert("ABCDE",2));
    }
}
