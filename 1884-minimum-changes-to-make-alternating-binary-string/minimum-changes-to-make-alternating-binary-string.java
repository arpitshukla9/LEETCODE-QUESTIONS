class Solution {
    public int minOperations(String s) {
        int startwithzero = 0;
        int startwithone = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '0') {
                    startwithone++;
                } else
                    startwithzero++;
            } else {
                if(s.charAt(i) == '1'){
                    startwithone++;
                } else startwithzero++;
            }
        }
        return Math.min(startwithzero, startwithone);
    }
}