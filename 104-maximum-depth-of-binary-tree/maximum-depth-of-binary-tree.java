class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        // if left null then check for right
        if(root.left == null) return 1 + maxDepth(root.right); 
        // if right null then check for left
        if(root.right == null) return 1 + maxDepth(root.left); 

        // if both not null
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

    }
}