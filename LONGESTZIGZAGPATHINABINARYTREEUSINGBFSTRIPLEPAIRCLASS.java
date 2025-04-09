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
    static class TriplePair {
        TreeNode node;
        int direction; 
        int distance;
        public TriplePair(TreeNode node, int direction, int distance) {
            this.node = node;
            this.direction = direction;
            this.distance = distance;
        }
    }
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        int maxLength = 0;
        Queue<TriplePair> q = new LinkedList<>();
        if (root.left != null)
            q.add(new TriplePair(root.left, 0, 1));
        if (root.right != null)
            q.add(new TriplePair(root.right, 1, 1));
        while (!q.isEmpty()) {
            TriplePair current = q.poll();
            maxLength = Math.max(maxLength, current.distance);
            if (current.direction == 0) {
                if (current.node.left != null)
                    q.add(new TriplePair(current.node.left, 0, 1)); 
                if (current.node.right != null)
                    q.add(new TriplePair(current.node.right, 1, current.distance + 1)); 
            } else {
                if (current.node.left != null)
                    q.add(new TriplePair(current.node.left, 0, current.distance + 1)); 
                if (current.node.right != null)
                    q.add(new TriplePair(current.node.right, 1, 1)); 
            }
        }
        return maxLength;
    }
}
