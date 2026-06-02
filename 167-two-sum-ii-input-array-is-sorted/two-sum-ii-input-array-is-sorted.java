class Solution {
    public int[] twoSum(int[] nums, int target) {
        int st = 0;
        int lt = nums.length - 1;
        while(st < lt) {
            int RemSum = target - nums[st];
            if(nums[lt] > RemSum) lt--;
            else if(nums[lt] == RemSum) return new int[]{st+1, lt+1};
            else st++;
        }
        return new int[]{-1, -1};
    }
}