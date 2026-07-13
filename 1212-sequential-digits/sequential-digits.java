class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        String digits = "123456789";
        for (int length = 2; length <= 9; length++) {
            for (int start = 0; start <= 9 - length; start++) {
                String sub = digits.substring(start, start + length);
                int num = Integer.parseInt(sub);
                if (num > high) {
                    break; 
                }
                if (num >= low) {
                    res.add(num);
                }
            }
        }
        return res;
    }
}