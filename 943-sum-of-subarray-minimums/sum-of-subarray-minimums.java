class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long totalSum = 0;
        int mod = 1_000_000_007;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i <= n; i++) {
            int currentVal = (i == n) ? 0 : arr[i];
            
            while (!stack.isEmpty() && arr[stack.peek()] > currentVal) {
                int mid = stack.pop();
                int leftBound = stack.isEmpty() ? -1 : stack.peek();
                int rightBound = i;
                
                long leftChoices = mid - leftBound;
                long rightChoices = rightBound - mid;
                
                long totalSubarrays = (leftChoices * rightChoices) % mod;
                totalSum = (totalSum + (totalSubarrays * arr[mid]) % mod) % mod;
            }
            stack.push(i);
        }
        
        return (int) totalSum;
    }
}