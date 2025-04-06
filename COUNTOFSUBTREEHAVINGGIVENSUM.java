class Tree {
    Map<Node, Integer> subtreeSumMap = new HashMap<>();
    int count = 0;

    int countSubtreesWithSumX(Node root, int X) {
        // Step 1: Compute all subtree sums in DFS (bottom-up)
        computeSubtreeSums(root);

        // Step 2: BFS traversal to check sum at each node
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            int sum = subtreeSumMap.get(curr);
            if (sum == X) {
                count++;
            }

            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }

        return count;
    }

    int computeSubtreeSums(Node root) {
        if (root == null) return 0;

        int left = computeSubtreeSums(root.left);
        int right = computeSubtreeSums(root.right);

        int total = root.data + left + right;
        subtreeSumMap.put(root, total);
        return total;
    }
}
