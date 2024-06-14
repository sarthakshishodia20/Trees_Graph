import java.util.ArrayList;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class findkthSmallestNodeinBST {
    public static int findKth(TreeNode root, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        inOrder(root, ans);
        return ans.get(k - 1);
    }

    public static void inOrder(TreeNode root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }
        inOrder(root.left, ans);
        ans.add(root.data);
        inOrder(root.right, ans);
    }

    public static void main(String[] args) {
        // Create a sample binary search tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        // Find the kth smallest element
        int k = 3;
        int kthSmallest = findKth(root, k);
        System.out.println("The " + k + "th smallest element is: " + kthSmallest);
    }
}
