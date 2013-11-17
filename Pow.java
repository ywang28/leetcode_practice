public class Pow {
    public double pow(double x, int n) {
        if(n==0)  return 1;
        if(n==1)  return x;
        if(n==-1)  return 1/x;
        double y = pow(x, n/2);
        return (n % 2 == 0) ? y * y : y * y * ((n > 0) ? x : 1/x);
    }
}
