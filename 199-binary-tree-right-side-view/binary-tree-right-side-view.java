class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int n = que.size();
            TreeNode node = null;
            
            while (n > 0) {
                node = que.peek();
                que.remove();

                if (n == 1) {
                    result.add(node.val);
                }

                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);

                n--;
            }
        }
        return result;
    }
}