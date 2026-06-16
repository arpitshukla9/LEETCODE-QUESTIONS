class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int maxLen = 0;
        
        for (int r = 0; r < s.length(); r++) {
            char currentChar = s.charAt(r);
            if (map.containsKey(currentChar)) {
                l = Math.max(l, map.get(currentChar) + 1);
            }
            map.put(currentChar, r);
            maxLen = Math.max(maxLen, r - l + 1);
        }
        
        return maxLen;
    }
}