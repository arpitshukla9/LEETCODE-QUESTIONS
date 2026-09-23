class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        // Base checks
        if (Math.abs(target) > totalSum) return 0;
        if ((target + totalSum) % 2 != 0 || (target + totalSum) < 0) return 0;

        int s2 = (target + totalSum) / 2;
        int[] dp = new int[s2 + 1];
        dp[0] = 1; // Base case: 1 way to make sum 0 (empty subset)

        for (int num : nums) {
            for (int j = s2; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[s2];
    }
}