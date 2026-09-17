class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // Map from original node to its clone
        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node neighbor : current.neighbors) {
                // Clone neighbor if not already cloned
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                // Wire up the cloned neighbor
                map.get(current).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}