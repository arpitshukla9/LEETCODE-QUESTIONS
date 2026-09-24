class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;
            int required = prefixSum - goal;
            if (map.containsKey(required)) {
                count += map.get(required);
            }

            map.put(prefixSum,
                    map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}