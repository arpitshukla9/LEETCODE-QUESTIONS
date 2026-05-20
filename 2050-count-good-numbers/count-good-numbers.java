class Solution {
    long M = 1_000_000_007;

    private long findPow(long a, long b) {
        if (b == 0) return 1;
        a %= M;
        if (b % 2 == 0) {
            return findPow((a * a) % M, b / 2);
        } else {
            return (a * findPow((a * a) % M, (b - 1) / 2)) % M;
        }
    }

    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2;
        long oddPositions = n / 2;

        long evenChoices = findPow(5, evenPositions);
        long oddChoices = findPow(4, oddPositions);

        return (int) ((evenChoices * oddChoices) % M);
    }
}