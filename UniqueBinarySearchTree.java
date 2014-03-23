public class UniqueBinarySearchTree {
    public int numTrees(int n) {
        if(n<0)  return 0;
        if(n==0)  return 1;
        // catalan number
        int[] catalan = new int[n+1];
        catalan[0] = 1;
        for(int i=1; i<=n; i++)  {
            catalan[i] = 0;
            for(int j=0; j<i/2; j++)  {
                catalan[i] += 2 * catalan[j] * catalan[i-j-1];
            }
            // add center value for odd num
            if(i%2==1)  {
                catalan[i] += catalan[i/2] * catalan[i/2];
            }
        }
        return catalan[n];
    }
}
