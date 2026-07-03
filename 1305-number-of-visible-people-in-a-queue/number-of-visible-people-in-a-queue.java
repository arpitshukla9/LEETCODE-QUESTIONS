class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[heights.length];

        for(int i = heights.length - 1; i >= 0; i--) {
            int count = 0;
            while(!st.isEmpty() && heights[i] >= heights[st.peek()]) {
                st.pop();
                count++;
            }
            if(!st.isEmpty()) count++;
            ans[i] = count;
            st.push(i);
        }
        return ans;
    }
}