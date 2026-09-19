class Solution {
    int maxSum = Integer.MIN_VALUE;

    int solve(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, solve(node.left));
        int right = Math.max(0, solve(node.right));

        maxSum = Math.max(maxSum, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
}