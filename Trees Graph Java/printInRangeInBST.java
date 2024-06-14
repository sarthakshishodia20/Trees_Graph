public class printInRangeInBST {
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
    public static int sumRangeBST(Node root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.data >= low && root.data <= high) {
            sum += root.data;
        }
        if (root.data > low) {
            sum += sumRangeBST(root.left, low, high);
        }
        if (root.data < high) {
            sum += sumRangeBST(root.right, low, high);
        }
        return sum;
    }
    public static void printInRange(Node root,int low,int high){
        if(root==null){
            return;
        }
        if(root.data>=low && root.data<=high){
            System.out.print(root.data+" ");
        }
        if(root.data>low){
            printInRange(root.left, low, high);
        }
        else{
            printInRange(root.right, low, high);
        }
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
        printInRange(root,low,high);
    }
    
}
