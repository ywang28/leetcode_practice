// 5.3
public class NextNum  {
    public static void main(String[] Args)  {
       NextNum t = new NextNum();
       t.solve(17);
    }
    public void solve(int num)  {
        int ones = countOnes(num);
        int max, min, cnt = 0, start = num;
        while(cnt != ones)  {
            cnt = countOnes(++start);
        }
        max = start;
        start = num;
        cnt = 0;
        while(cnt != ones)  {
            cnt = countOnes(--start);
        }
        min = start;
        System.out.println("max: " + max + " min: " + min);
    }
    public int countOnes(int n)  {
        int cnt = 0;
        while(n > 0)  {
            // bit 1 found
            if((n & 1) == 1)  {
                cnt++;
            }
            // examine next bit
            n >>= 1;
        }
        return cnt;
    }
}
