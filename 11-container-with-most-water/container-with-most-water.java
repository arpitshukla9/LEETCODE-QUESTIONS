class Solution {
    public int maxArea(int[] height) {
        int st = 0;
        int lt = height.length - 1;
        int ans = 0;
        while (st < lt) {
            int prod = 1;
            if (height[st] < height[lt]) {
                prod *= height[st] * (lt - st);
                ans = Math.max(ans, prod);
                st++;
            } else {
                prod *= height[lt] * (lt - st);
                ans = Math.max(ans, prod);
                lt--;
            }
        }
        return ans;
    }
}