class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();        
        for (int ast : asteroids) {
            boolean exploded = false;
            
            while (!st.isEmpty() && st.peek() > 0 && ast < 0) {
                if (Math.abs(st.peek()) < Math.abs(ast)) {
                    st.pop();
                    continue;
                } else if (Math.abs(st.peek()) == Math.abs(ast)) {
                    st.pop();
                    exploded = true;
                    break;
                } else {
                    exploded = true;
                    break;
                }
            }
            
            if (!exploded) {
                st.push(ast);
            }
        }
        
        int[] result = new int[st.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop();
        }
        
        return result;
    }
}