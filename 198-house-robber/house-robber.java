class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(nums, 0, n, dp);
    }

    int solve(int[] arr, int i, int n, int[] dp) {
        if (i >= n) return 0;
        if (dp[i] != -1) return dp[i];

        int steal = arr[i] + solve(arr, i + 2, n, dp);
        int skip = solve(arr, i + 1, n, dp);

        return dp[i] = Math.max(steal, skip);
    }
}