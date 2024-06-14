

public class DeleteaNode {
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
    
    public static Node delete(Node root, int val) {
        if (root == null) {
            return null;
        }
        if (root.data < val) {
            root.right = delete(root.right, val);
        } else if (root.data > val) {
            root.left = delete(root.left, val);
        } else {
            // Case 1: No child or only one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 2: Node with two children
            root.data = findInorderSuccessor(root.right).data;
            root.right = delete(root.right, root.data);
        }
        return root;
    }
    
    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
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
        
        int deleteValue = 1;
        System.out.println("Deleting node with value: " + deleteValue);
        root = delete(root, deleteValue);
        
        System.out.print("Inorder Traversal after deletion of " + deleteValue + ": ");
        InOrder(root);
        
    }
}
