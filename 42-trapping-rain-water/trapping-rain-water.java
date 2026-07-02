class Solution {
    int solve(int[] arr){
        int lMax = 0,  rMax = 0, l = 0;
        int r = arr.length - 1;
        int total = 0;
        while(l < r) {
            if(arr[l] <= arr[r]) {
                if(lMax > arr[l]) {
                    total += lMax - arr[l];
                } else {
                    lMax = arr[l];
                }
            l = l + 1;
            } else {
                if(rMax > arr[r]){
                    total += rMax - arr[r];
                } else {
                    rMax = arr[r];
                }
                r = r -1;
            }
            
        }
        return total;
        
    }
    public int trap(int height[]) {
        return solve(height);
        
    }
}
