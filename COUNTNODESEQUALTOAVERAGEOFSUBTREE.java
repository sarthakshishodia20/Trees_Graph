/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int averageOfSubtree(TreeNode root) {
        return helper(root);
    }
    public static int countOfNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = countOfNodes(root.left);
        int rightCount = countOfNodes(root.right);
        return leftCount + rightCount + 1;
    }
    public static int sumOfNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sumOfNodes(root.left) + sumOfNodes(root.right);
    }
    public static int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int countOfnodes = countOfNodes(root);
        int sumOfNode = sumOfNodes(root);
        int curr = (sumOfNode / countOfnodes) == root.val ? 1 : 0;
        return curr + helper(root.left) + helper(root.right);
    }
}
