class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        
        // Agar left child null hai, toh right subtree ki depth check karo
        if (root.left == null) return 1 + minDepth(root.right);
        
        // Agar right child null hai, toh left subtree ki depth check karo
        if (root.right == null) return 1 + minDepth(root.left);
        
        // Agar dono children hain, tabhi minimum depth lo
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}