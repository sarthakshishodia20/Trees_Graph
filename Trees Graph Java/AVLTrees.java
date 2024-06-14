public class AVLTrees {
    // Node class
    static class Node {
        int data, height;
        Node left, right;

        public Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    public static Node root;

    // Function to get height of a node
    public static int Height(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    // Right rotate subtree rooted with y subroot
    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(Height(y.left), Height(y.right)) + 1;
        x.height = Math.max(Height(x.left), Height(x.right)) + 1;

        return x;
    }

    // Left rotate rooted with x.
    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(Height(x.left), Height(x.right)) + 1;
        y.height = Math.max(Height(y.left), Height(y.right)) + 1;

        return y;
    }

    // Get balance factor
    public static int getBalance(Node root) {
        if (root == null) {
            return 0;
        }
        return Height(root.left) - Height(root.right);
    }

    // Insertion
    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        } else {
            return root;
        }
        root.height = Math.max(Height(root.left), Height(root.right)) + 1;

        // Get balance factor
        int bf = getBalance(root);

        // Left Left Case
        if (bf > 1 && key < root.left.data) {
            return rightRotate(root);
        }
        // Right Right Case
        if (bf < -1 && key > root.right.data) {
            return leftRotate(root);
        }
        // Left Right Case
        if (bf > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // Right Left Case
        if (bf < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        preOrder(root);
    }
}
