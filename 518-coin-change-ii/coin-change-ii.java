class Solution {
    public int change(int amount, int[] coins) {
       long[][] dp = new long[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = -1;
            }
        }
        return (int) solve(coins, amount, 0, dp);
    }

    long solve(int[] coins, int amount, int i, long[][] dp) {
        if (amount == 0) return 1;
        if(i == coins.length || amount < 0) return 0;

        if (dp[i][amount] != -1) return dp[i][amount];

        long skip = solve(coins, amount, i + 1, dp);
        long pick = 0;
        if (amount - coins[i] >= 0) {
            pick = solve(coins, amount - coins[i], i, dp);
        }
        return dp[i][amount] = skip + pick;
    }
}