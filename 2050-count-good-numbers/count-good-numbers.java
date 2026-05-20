class Solution {
    long M = 1_000_000_007;
    int myPow(long a , long b){
    if(b == 0) return 1;
    if(b < 0) return myPow(1/a % M, -b);
    if(b % 2 == 0) return (int) (myPow((a*a) % M, b/2) % M);
    else return (int) ((a * myPow((a*a ) % M, (b - 1)/2)) % M);
    }
    public int countGoodNumbers(long n) {
        return (int) (((long) myPow(5, (n + 1)/2) * myPow(4, n/2)) % M);
    }
}