public class BuildBST {
    static class Node{
        int data;
        Node left;
        Node right;
        
        public Node(int data){
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
            // Insert into the left subtree
            root.left = insert(root.left, val);
        } else if (val > root.data) {
            // Insert into the right subtree
            root.right = insert(root.right, val);
        }
        // If val is equal to root.data, we don't do anything since BST typically does not contain duplicates
        return root;
        
    }
    
    public static void InOrder(Node root) {
        if(root == null){
            return ;
        }
        InOrder(root.left);
        System.out.print(root.data+" ");
        InOrder(root.right);
    }
    
    public static void main(String[] args) {
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        InOrder(root);
    }
}
