public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fastPow(x, n);
    } 
    double fastPow(double base, int exponent) {
        if (exponent == 0) return 1.0;
        double half = fastPow(base, exponent / 2);
        if (exponent % 2 == 0) return half * half;
        else return half * half * base;
    }
}
