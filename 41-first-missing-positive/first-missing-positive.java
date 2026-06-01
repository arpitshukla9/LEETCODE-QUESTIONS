class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int expected = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || (i > 0 && nums[i] == nums[i - 1])) {
                continue;
            }
            if (nums[i] == expected) {
                expected++;
            } else {
                break;
            }
        }

        return expected;
    }
}