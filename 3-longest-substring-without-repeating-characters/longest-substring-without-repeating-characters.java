class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128]; 
        Arrays.fill(map, -1);
        
        int l = 0;
        int maxLen = 0;
        
        for (int r = 0; r < s.length(); r++) {
            char currentChar = s.charAt(r);
            
            if (map[currentChar] != -1) {
                l = Math.max(l, map[currentChar] + 1);
            }
            
            map[currentChar] = r;
            maxLen = Math.max(maxLen, r - l + 1);
        }
        
        return maxLen;
    }
}