class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        for(int i = 0; i < arr1.length; i++){
            int counter = solve(arr1, arr2, d, i);
            ans += counter;
        }
        return ans;
    }
    int solve(int[] arr1, int[] arr2, int d, int idx) {
        for(int i = 0; i < arr2.length; i++){
            int val = Math.abs(arr1[idx]-arr2[i]);
            if(val <= d) return 0;
        }
        return 1;
    }
}