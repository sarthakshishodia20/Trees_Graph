public class CountNodesinRange {
    static class Node {
        int data;
        Node left;
        Node right;
        
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val < root.data) {
            root.left = insert(root.left, val); // Insert into the left subtree
        } else if (val > root.data) {
            root.right = insert(root.right, val); // Insert into the right subtree
        }
        // If val is equal to root.data, we don't do anything since BST typically does not contain duplicates
        return root;
    }
    
    public static void InOrder(Node root) {
        if(root == null) {
            return;
        }
        InOrder(root.left);
        System.out.print(root.data + " ");
        InOrder(root.right);
    }
    public static int getCount(Node root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.data >= low && root.data <= high) {
            count++;
        }
        if (root.data > low) {
            count += getCount(root.left, low, high);
        }
        if (root.data < high) {
            count += getCount(root.right, low, high);
        }
        return count;
    }
    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        System.out.print("Inorder Traversal before deletion: ");
        InOrder(root);
        System.out.println();
        int low = 3;
        int high = 10;
        int count = getCount(root, low, high);
        System.out.println(count);
    }
    
}
