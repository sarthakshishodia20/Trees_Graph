class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (node == null) return ans;
        if (!isLeaf(node)) {
            ans.add(node.data);
        }
        leftBoundary(node, ans);
        leafBoundary(node, ans);
        rightBoundary(node, ans);

        return ans;
    }

    public static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }
    public static void leftBoundary(Node root, ArrayList<Integer> list) {
        Node curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) {
                list.add(curr.data);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    public static void leafBoundary(Node root, ArrayList<Integer> list) {
        if (root == null) return;
        if (isLeaf(root)) {
            list.add(root.data);
            return;
        }
        leafBoundary(root.left, list);
        leafBoundary(root.right, list);
    }
    public static void rightBoundary(Node root, ArrayList<Integer> list) {
        Stack<Integer> s = new Stack<>();
        Node curr = root.right;
        while (curr != null) {
            if (!isLeaf(curr)) {
                s.push(curr.data);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        while (!s.isEmpty()) {
            list.add(s.pop());
        }
    }
}
