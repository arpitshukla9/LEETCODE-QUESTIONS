class Solution {
    public int minOperations(String s) {
        int len = s.length();
        int ans = 0;

        for (int i = 0; i < len; i++) {
            if (i % 2 == 0 && s.charAt(i) == '1')
                ans++;

            if (i % 2 == 1 && s.charAt(i) == '0')
                ans++;
        }
        return Math.min(ans, len - ans);
    }
}