public class RecoverBST {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        TreeNode(int x) {
            this.data = x;
            this.left = null;
            this.right = null;
        }
        TreeNode(int x, TreeNode left, TreeNode right) {
            this.data = x;
            this.left = left;
            this.right = right;
        }
    }

    static TreeNode first = null;
    static TreeNode second = null;
    static TreeNode prev = null;

    public static void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        if(prev!=null && prev.data>=root.data){
            if(first==null){
                first=prev;
            }
            second=root;
        }
        prev=root;
        inOrder(root.right);
    }

    public static TreeNode FixBST(TreeNode root) {
        // Write your code here
        if(root==null){
            return null;
        }
        new RecoverBST();
        RecoverBST.inOrder(root);
        if(first!=null && second!=null){
            int t=first.data;
            first.data=second.data;
            second.data=t;
        }
        return root;
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(Integer.MIN_VALUE);
        root.left.right = new TreeNode(2);

        System.out.println("Original tree:");
        printInOrder(root);

        FixBST(root);

        System.out.println("\nFixed tree:");
        printInOrder(root);
    }

    public static void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.data + " ");
            printInOrder(root.right);
        }
    }
}
