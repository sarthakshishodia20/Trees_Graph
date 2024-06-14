class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

class Node {
    int data;

    public Node(int item) {
        data = item;
    }
}

public class findClosestNodeinBST {
    public Node findClosestElement(TreeNode root, int value) {
        if (root == null) {
            return null;
        }
        int minDiff = Integer.MAX_VALUE;
        TreeNode closestElementNode = null;
        while (root != null) {
            int currDiff = Math.abs(root.data - value);
            if (currDiff < minDiff) {
                minDiff = currDiff;
                closestElementNode = root;
            }
            if (value < root.data) {
                root = root.left;
            } else if (value > root.data) {
                root = root.right;
            } else {
                break;
            }
        }
        return new Node(closestElementNode.data);
    }

    public static void main(String[] args) {
        // Create a sample binary search tree
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(4);
        root.right = new TreeNode(17);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(22);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(7);

        int value = 8;
        findClosestNodeinBST finder = new findClosestNodeinBST();
        Node closestNode = finder.findClosestElement(root, value);
        if (closestNode != null) {
            System.out.println("The closest element in the BST to " + value + " is: " + closestNode.data);
        } else {
            System.out.println("The BST is empty.");
        }
    }
}
