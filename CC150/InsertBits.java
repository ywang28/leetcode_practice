// 5.1
public class InsertBits  {
    public static void main(String[] Args)  {
       InsertBits t = new InsertBits();
       t.solve(Integer.parseInt("10011",2), Integer.parseInt("10000000000",2), 2, 6);
    }
    public void solve(int M, int N, int i, int j)  {
       int mask = (~0 << j) | (~0 >> (32-i));
       N = N & mask;
       int ans = N | (M << i);
       System.out.println(Integer.toBinaryString(ans));
    }
}
