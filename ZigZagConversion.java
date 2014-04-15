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
    // 2nd try
    public String convert2(String s, int nRows) {
        if(s==null || nRows < 2 || s.length()<=nRows)  return s;
        int index = 0, row = 0, len = s.length();
        StringBuilder sb = new StringBuilder();
        while(sb.length() < len)  {
            sb.append(s.charAt(index));
            // first and last row are boundary
            boolean boundary = (row == 0 || row == nRows-1) ? true : false;
            // for boundary rows, jump step is 2*nRows-2
            if(boundary)  {
                int next = index + 2*nRows - 2;
                while(next < len)  {
                    sb.append(s.charAt(next));
                    next += 2*nRows - 2;
                }
            }
            // for internal rows, there is one more jump in between
            else  {
                int next = index + 2*nRows - 2;
                // if bigger jump is valid, append both internal char and jump char
                while(next < len)  {
                    sb.append(s.charAt(next - 2*row));
                    sb.append(s.charAt(next));
                    next += 2*nRows - 2;
                }
                int prev = next - 2*row;
                // append internal jummp in case it's valid. update next index
                if(prev < len)  {
                    sb.append(s.charAt(prev));
                }
            }
            index++;
            row++;
        }
        return sb.toString();
    }
    public static void main(String[] Args)  {
        System.out.println(convert("ABCDE",2));
    }
}
