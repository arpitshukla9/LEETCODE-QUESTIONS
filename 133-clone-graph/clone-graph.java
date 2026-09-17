class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // If already cloned, return the clone (handles cycles)
        if (map.containsKey(node)) return map.get(node);

        // Create clone and add to map before recursing
        Node clone = new Node(node.val);
        map.put(node, clone);

        // Recursively clone all neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}