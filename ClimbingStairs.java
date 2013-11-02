public class ClimbingStairs {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n<1)  return 0;
        if(n==1)  return 1;
        if(n==2)  return 2;
        int[] sol = new int[n+1];
        sol[0] = 0;
        sol[1] = 1;
        sol[2] = 2;
        for(int i=3; i<=n; i++)  {
            sol[i] = sol[i-1] + sol[i-2];
        }
        return sol[n];
    }
}
