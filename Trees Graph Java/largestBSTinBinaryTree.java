public class largestBSTinBinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static int maxBST = 0;
    static int maxSum = 0;

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;
        int sum;

        public Info(boolean isBST, int size, int min, int max, int sum) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }

        // Additional constructor for initializing with default values
        public Info() {
            this.isBST = false;
            this.size = 0;
            this.min = Integer.MAX_VALUE;
            this.max = Integer.MIN_VALUE;
            this.sum = 0;
        }
    }

    public static Info largestBST(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max, 0);
        }
        if (leftInfo.isBST && rightInfo.isBST) {
            int currentSum = leftInfo.sum + rightInfo.sum + root.data;
            maxBST = Math.max(maxBST, size);
            maxSum = Math.max(maxSum, currentSum);

            return new Info(true, size, min, max, currentSum);
        }
        return new Info(false, size, min, max, 0);
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);
        // Info info = largestBST(root);
        System.out.println("Maximum Size of Largest BST: " + maxBST);
        System.out.println("Maximum Sum of Largest BST: " + maxSum);
    }
}
