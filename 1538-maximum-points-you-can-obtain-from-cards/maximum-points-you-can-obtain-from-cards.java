class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        for(int i = 0 ; i < k; i++) {
            leftSum += cardPoints[i];
        }
        int maxSum = leftSum;
        int rightSum = leftSum;
        int rIdx = cardPoints.length - 1;
        for(int i = k -1; i >= 0; i--) {
            rightSum -= cardPoints[i];
            rightSum += cardPoints[rIdx];
            maxSum = Math.max(maxSum, rightSum);
            rIdx = rIdx - 1;   
        }
        return maxSum;
    }
}