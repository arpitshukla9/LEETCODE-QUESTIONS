class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return solvebyMemo(n, memo);
    }
    // BRUTE-FORCE -> TLE
    int solve(int n ){
        if(n < 0) return 0;
        if(n == 0) return 1;
        int one_step = solve(n-1);
        int two_step = solve(n-2);
        return one_step + two_step;
    }
    // memoization
    int solvebyMemo(int n , int[] memo){
        if (n < 0) return 0;
        if (n == 0) return 1;

        // Return cached result if already computed
        if (memo[n] != -1) {
            return memo[n];
        }

        // Store result in memo array and return
        memo[n] = solvebyMemo(n - 1, memo) + solvebyMemo(n - 2, memo);
        return memo[n];
    }
}