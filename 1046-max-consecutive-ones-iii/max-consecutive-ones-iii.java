class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        int l = 0, r = 0;
        int zeroCt = 0;

        while (r < nums.length) {
            if (nums[r] == 0) {
                zeroCt++;
            }
            while (zeroCt > k) {
                if (nums[l] == 0) {
                    zeroCt--;
                }
                l++;
            }
            int len = r - l + 1;
            maxLen = Math.max(maxLen, len);
            r++;
        }

        return maxLen;
    }
}