class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0]; 
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int case1 = solve(nums, 0, n-1, dp);

        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int case2 = solve(nums, 1, n, dp2);

        return Math.max(case1, case2);
    }

    //  memoization
    int solve(int[] arr, int i, int n, int[] dp) {
        if (i >= n) return 0;
        if (dp[i] != -1) return dp[i];

        int steal = arr[i] + solve(arr, i + 2, n, dp);
        int skip = solve(arr, i + 1, n, dp);

        return dp[i] = Math.max(steal, skip);
    }
}