class Solution {
    public void moveZeroes(int[] nums) {
        int writePointer = 0;
        for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    int temp = nums[writePointer];
                    nums[writePointer] = nums[i];
                    nums[i] = temp;
                    writePointer++;
                }
            
        }
    }
}
