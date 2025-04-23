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
    public static void getLeaves(TreeNode root, ArrayList<TreeNode> list){
        if(root == null) return;
        if(root.left == null && root.right == null){
            list.add(root);
            return;
        }
        getLeaves(root.left, list);
        getLeaves(root.right, list);
    }

    public int countPairs(TreeNode root, int distance) {
        ArrayList<TreeNode> leaves = new ArrayList<>();
        getLeaves(root, leaves);
        int count = 0;
        for(int i = 0; i < leaves.size(); i++){
            for(int j = i + 1; j < leaves.size(); j++){
                int dist = distanceBetweenNodes(root, leaves.get(i), leaves.get(j));
                if(dist <= distance){
                    count++;
                }
            }
        }
        return count;
    }
    public static TreeNode getLCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;
        if(root == p || root == q) return root;

        TreeNode left = getLCA(root.left, p, q);
        TreeNode right = getLCA(root.right, p, q);

        if(left != null && right != null) return root;
        return left != null ? left : right;
    }
    public static int distanceBetweenNodes(TreeNode root, TreeNode node1, TreeNode node2){
        TreeNode lca = getLCA(root, node1, node2);
        int d1 = getDepth(lca, node1, 0);
        int d2 = getDepth(lca, node2, 0);
        return d1 + d2;
    }
    public static int getDepth(TreeNode root, TreeNode target, int depth){
        if(root == null) return -1;
        if(root == target) return depth;

        int left = getDepth(root.left, target, depth + 1);
        if(left != -1) return left;

        return getDepth(root.right, target, depth + 1);
    }
}
