class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true; // flag to check alternate level

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // Zigzag order ke acc node.val add karein
                if (leftToRight) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val); // Front mein insert karein
                }

                // Always standard Left to Right push karein
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(level);
            leftToRight = !leftToRight; // Alternate direction
        }

        return result;
    }
}