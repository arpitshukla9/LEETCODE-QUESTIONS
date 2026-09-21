class Solution {
    public int coinChange(int[] coins, int amount) { // Fix 1: Return type must be int
        long[][] dp = new long[coins.length][amount + 1]; // Fix 2: Second dimension must be amount + 1
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) { // Fix 3: Loop up to amount inclusive
                dp[i][j] = -1;
            }
        }
        long ans = solve(coins, amount, 0, dp);
        if (ans == Integer.MAX_VALUE) return -1;
        return (int) ans;
    }

    long solve(int[] coins, int amount, int i, long[][] dp) {
        if (i == coins.length) {
            if (amount == 0) return 0;
            else return Integer.MAX_VALUE;
        }
        if (dp[i][amount] != -1) return dp[i][amount];

        long skip = solve(coins, amount, i + 1, dp);
        if (amount - coins[i] < 0) return dp[i][amount] = skip;

        long pick = 1 + solve(coins, amount - coins[i], i, dp);
        return dp[i][amount] = Math.min(skip, pick);
    }
}