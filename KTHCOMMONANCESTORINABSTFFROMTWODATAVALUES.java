class Solution {
    public static void assignParents(Node root, HashMap<Node, Node> map) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node currNode = q.poll();
            if (currNode.left != null) {
                q.add(currNode.left);
                map.put(currNode.left, currNode);
            }
            if (currNode.right != null) {
                q.add(currNode.right);
                map.put(currNode.right, currNode);
            }
        }
        return;
    }

    public int kthCommonAncestor(Node root, int k, int x, int y) {
        HashMap<Node, Node> map = new HashMap<>();
        map.put(root, null);
        assignParents(root, map);

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node node1 = null;
        Node node2 = null;

        // Find nodes x and y
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node currNode = q.poll();
                if (currNode.data == x) {
                    node1 = currNode;
                }
                if (currNode.data == y) {
                    node2 = currNode;
                }
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }

        if (node1 == null || node2 == null) {
            return -1;
        }
        HashSet<Node> ancestors = new HashSet<>();
        while (node1 != null) {
            ancestors.add(node1);
            node1 = map.get(node1);
        }
        ArrayList<Node> commonAncestors = new ArrayList<>();
        while (node2 != null) {
            if (ancestors.contains(node2)) {
                commonAncestors.add(node2);
            }
            node2 = map.get(node2);
        }
        if (k > commonAncestors.size()) {
            return -1;
        }
        return commonAncestors.get(k - 1).data;
    }
}
