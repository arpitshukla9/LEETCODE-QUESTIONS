class Solution {
    public int maxProduct(int[] nums) {

        int maxPro = nums[0];
        int prefixPro = 1;
        int suffixPro = 1;

        for (int i = 0; i < nums.length; i++) {

            if (prefixPro == 0)
                prefixPro = 1;

            if (suffixPro == 0)
                suffixPro = 1;

            prefixPro *= nums[i];
            suffixPro *= nums[nums.length - 1 - i];

            maxPro = Math.max(maxPro, Math.max(prefixPro, suffixPro));
        }

        return maxPro;
    }
}