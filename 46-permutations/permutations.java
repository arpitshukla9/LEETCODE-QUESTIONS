class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        boolean[] check = new boolean[nums.length];
        permutations(nums, ans , a , check);
        return ans;
    }
    void permutations(int[] nums, List<List<Integer>> ans, List<Integer> a, boolean[] check){
        int n = nums.length;
        if(a.size() == n){
            List<Integer> copy = new ArrayList<>(a);
            ans.add(copy);
            return;
        }
        for(int i = 0; i < n; i++){
            if(!check[i]){
                a.add(nums[i]);
                check[i] = true;
                permutations(nums, ans, a, check);
                a.remove(a.size()-1);
                check[i] = false;
            }
        }
    }
}