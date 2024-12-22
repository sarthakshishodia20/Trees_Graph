/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return root.val;
        }
        Queue<TreeNode> q = new LinkedList<>();
        int sum = 0;
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode current = q.poll();
                if (current.val % 2 == 0) {
                    if (current.left != null) {
                        sum += CheckAns(current.left.left) + CheckAns(current.left.right);
                    }
                    if (current.right != null) {
                        sum += CheckAns(current.right.left) + CheckAns(current.right.right);
                    }
                }
                if (current.left != null) {
                    q.add(current.left);

                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
        }
        return sum;
    }

    public static int CheckAns(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val;
    }
}
