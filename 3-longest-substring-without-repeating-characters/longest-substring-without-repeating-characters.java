class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        char[] arr = s.toCharArray();
        int start = 0;
        int next = start + 1;
        while (start < n) {
            boolean[] visit = new boolean[256]; 
            int length = 0;
            for (int i = start; i < n; i++) {
                if (visit[arr[i]]) {
                    break;
                }
                visit[arr[i]] = true;
                length +=1;
            }
            maxLength = Math.max(maxLength, length);
            start++;
        }
        return maxLength;
    }
}