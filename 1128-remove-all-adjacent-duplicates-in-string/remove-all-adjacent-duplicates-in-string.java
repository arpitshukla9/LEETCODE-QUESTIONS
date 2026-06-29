class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!st.isEmpty() && st.peek() == c) {
                st.pop();
            } else {
                st.push(c);
            }
        }
        
        StringBuilder sb = new StringBuilder(st.size());
        for (Character c : st) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}