class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
    
        for (int len = n; len >= 1; len--) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len;
                String substring = s.substring(i, j);
                
                if (isPalindrome(substring)) {
                    return substring;
                }
            }
        }
        
        return "";
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}