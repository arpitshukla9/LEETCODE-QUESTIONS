class Solution {
    public int minOperations(int[] nums) {
        int minOp = 0;
        for (int i = 0; i <= nums.length - 3; i++) {
            if (nums[i] == 0) {
                nums[i] ^= 1;    
                nums[i + 1] ^= 1; 
                nums[i + 2] ^= 1; 
                minOp++;          
            }
        }
        if (nums[nums.length - 2] == 0 || nums[nums.length - 1] == 0) {
            return -1;
        }
        
        return minOp;
    }
}