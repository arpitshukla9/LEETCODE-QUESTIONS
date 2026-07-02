class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] pse = findPSE(arr);
        int[] nse = findNSE(arr);
        
        long totalSum = 0;
        int mod = 1_000_000_007;
        
        for (int i = 0; i < n; i++) {
            long leftChoices = i - pse[i];
            long rightChoices = nse[i] - i;
            long totalSubarrays = (leftChoices * rightChoices) % mod;
            
            totalSum = (totalSum + (totalSubarrays * arr[i]) % mod) % mod;
        }
        
        return (int) totalSum;
    }
    
    private int[] findPSE(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Arrays.fill(pse, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                pse[i] = stack.peek();
            }
            stack.push(i);
        }
        return pse;
    }
    
    private int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Arrays.fill(nse, n);
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                nse[i] = stack.peek();
            }
            stack.push(i);
        }
        return nse;
    }
}