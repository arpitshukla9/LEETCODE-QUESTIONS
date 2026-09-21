class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Scenario 1: Rob within range [0, n - 2]
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int case1 = solve(nums, 0, n - 1, dp1);

        // Scenario 2: Rob within range [1, n - 1]
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int case2 = solve(nums, 1, n, dp2);

        return Math.max(case1, case2);
    }

    // Standard linear House Robber memoization helper
    int solve(int[] arr, int i, int end, int[] dp) {
        if (i >= end) return 0;
        if (dp[i] != -1) return dp[i];

        int steal = arr[i] + solve(arr, i + 2, end, dp);
        int skip = solve(arr, i + 1, end, dp);

        return dp[i] = Math.max(steal, skip);
    }
}