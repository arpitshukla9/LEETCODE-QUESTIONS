class Solution {
    public boolean isValid(String s) {
        String prev = "";
        while (!s.equals(prev)) {
            prev = s;
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        }
        return s.isEmpty();
    }
}