class Solution {
    static int sum;
    int ways(int i, int[] arr, int res, int target , int[][] dp){
        if(i == arr.length) {
            if(res == target) return 1;
            else return 0;
        }
        if(dp[i][res+sum] != -1) return dp[i][res+sum];
        int add = ways(i+1, arr, res+arr[i], target, dp);
        int sub = ways(i+1, arr, res-arr[i], target, dp);
        return dp[i][res+sum] = add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        sum = 0;
        for(int ele : nums) sum += ele;
        int[][] dp = new int[n][2*sum + 1];
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        } 
        return ways(0, nums, 0, target , dp);
    }
}