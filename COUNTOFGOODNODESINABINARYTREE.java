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
    static class Pair {
        TreeNode node;
        int maxSoFar;
        public Pair(TreeNode node, int maxSoFar){
            this.node = node;
            this.maxSoFar = maxSoFar;
        }
    }

    public int goodNodes(TreeNode root) {
        int count = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, root.val));
        while(!q.isEmpty()){
            Pair current = q.poll();
            if(current.node.val >= current.maxSoFar){
                count++;
            }
            int newMax = Math.max(current.maxSoFar, current.node.val);
            if(current.node.left != null){
                q.add(new Pair(current.node.left, newMax));
            }
            if(current.node.right != null){
                q.add(new Pair(current.node.right, newMax));
            }
        }
        return count;
    }
}
