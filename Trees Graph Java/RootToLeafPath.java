import java.util.*;

public class RootToLeafPath {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    static class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new ArrayList<>();
            if (root != null) {
                printPaths(root, "", paths);
            }
            return paths;
        }
        
        public void printPaths(TreeNode root, String ans, List<String> paths) {
            ans += root.val;
            if (root.left == null && root.right == null) {
                paths.add(ans);
                return;
            }
            if (root.left != null) {
                printPaths(root.left, ans + "->", paths);
            }
            if (root.right != null) {
                printPaths(root.right, ans + "->", paths);
            }
        }
    }

    public static void main(String[] args) {
        // Create a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        // Create an instance of Solution class
        Solution solution = new Solution();

        // Get the root-to-leaf paths
        List<String> paths = solution.binaryTreePaths(root);

        // Print the root-to-leaf paths
        System.out.println("Root-to-leaf paths:");
        for (String path : paths) {
            System.out.println(path);
        }
    }
}
