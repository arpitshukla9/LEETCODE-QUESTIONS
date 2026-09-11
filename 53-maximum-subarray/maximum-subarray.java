class Solution {
    public int maxSubArray(int[] arr) {
        int maxi = Integer.MIN_VALUE;
        int prefix = 0;
        for(int i = 0; i<arr.length; i++){
            prefix += arr[i];
            maxi = Math.max(maxi, prefix);
            if(prefix < 0) prefix = 0;
        }
        return maxi;
    }
}
