class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            maxHeap.add(piles[i]);
            sum += piles[i]; 
        }
        while (k > 0 && !maxHeap.isEmpty()) {
            int originalMax = maxHeap.poll();
            int removed = originalMax / 2;     
            sum -= removed;        
            maxHeap.add(originalMax - removed); 
            k--;
        }
        return sum;
    }
}