class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        int level = 1;
        preOrder(root, result , level);
        return result;
    }
    private void preOrder(TreeNode node , List<Integer> result, int level){
        if(node == null) return;
        if(result.size() < level) {
            result.add(node.val);
        }
        preOrder(node.right, result, level+1);
        preOrder(node.left, result, level+1);
    }
}