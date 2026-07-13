class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        String digits = "123456789";
        for (int i = 2; i <= 9; i++) {
            for (int j = 0; j <= 9 - i; j++) {
                String sub = digits.substring(j, j + i);
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