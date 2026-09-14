class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        // Total Sum
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }

        // Max_SubArray_Sum (Kadane's Algo)
        int maxi = nums[0];
        int prefix = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix = Math.max(nums[i], prefix + nums[i]);
            maxi = Math.max(maxi, prefix);
        }

        // Min_SubArray_Sum (Kadane's Algo)
        int minSub = nums[0];
        int prefixMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixMin = Math.min(nums[i], prefixMin + nums[i]);
            minSub = Math.min(minSub, prefixMin);
        }

        // All negative
        if (maxi < 0)
            return maxi;

        // Circular_SubArray_Sum
        int circularSubarraySum = totalSum - minSub;

        // return max 
        return Math.max(circularSubarraySum, maxi);
    }
}