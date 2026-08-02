public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        Arrays.sort(strs);
        StringBuilder result = new StringBuilder();
        String first = strs[0];
        String last = strs[strs.length - 1];
        for (int i = 0; i < first.length(); i++) {
            if (i >= last.length() || first.charAt(i) != last.charAt(i)) {
                break;
            }
            result.append(first.charAt(i));
        }
        return result.toString();
    }
}
