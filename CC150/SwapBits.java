// 5.6
public class SwapBits  {
    public static void main(String[] Args)  {
       SwapBits t = new SwapBits();
       t.solve(Integer.parseInt("10100110011",2));
    }
    public void solve(int n)  {
       int mask = 1;
       // build mask 010101...01
       for(int i=0; i<15; i++)  {
           mask <<= 2;
           mask++;
       }
       // merge odd bits in n<<1 and even bits in n>>1
       int tmp1 = n<<1;
       tmp1 |= mask;
       int tmp2 = n>>1;
       mask <<= 1;
       tmp2 |= mask;
       int ans = tmp1 & tmp2;
       System.out.println(Integer.toBinaryString(ans));
    }
}
