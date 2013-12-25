// 5.2
public class RealInBinary  {
    public static void main(String[] Args)  {
        RealInBinary t = new RealInBinary();
        System.out.println(t.solve(Double.parseDouble(Args[0])));
    }
    public String solve(double d)  {
        if(d>=1 || d<=0)  return "ERROR";
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        for(int i=0; i<32; i++)  {
            d *= 2;
            if(d >= 1)  {
                d -= 1;
                sb.append('1');
            }
            else  {
                sb.append('0');
            }
            if(d == 0)  return sb.toString();
        }
        return "ERROR";
    }
}
