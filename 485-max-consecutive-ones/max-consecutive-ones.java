class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = 0;
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                int crrLen = 0;
                len += 1;
                crrLen = len; 
                maxLen = Math.max(maxLen, crrLen);
            } else len = 0;
        }
        return maxLen;
    }
}