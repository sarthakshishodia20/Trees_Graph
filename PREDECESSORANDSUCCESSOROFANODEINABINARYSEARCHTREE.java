class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        Node floorPredecessor = getPre(root, key);
        Node ceilSuccessor = getSuc(root, key);
        ArrayList<Node> list = new ArrayList<>();
        list.add(floorPredecessor);
        list.add(ceilSuccessor);
        return list;
    }

    public static Node getPre(Node root, int key) {
        Node pre = null;
        while (root != null) {
            if (root.data >= key) {
                root = root.left;
            } else {
                pre = root;
                root = root.right;
            }
        }
        return pre;
    }

    public static Node getSuc(Node root, int key) {
        Node suc = null;
        while (root != null) {
            if (root.data <= key) {
                root = root.right;
            } else {
                suc = root;
                root = root.left;
            }
        }
        return suc;
    }
}
