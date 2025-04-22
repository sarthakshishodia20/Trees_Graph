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
    public static TreeNode LCA(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (root.val == p || root.val == q) return root;

        TreeNode leftLCA = LCA(root.left, p, q);
        TreeNode rightLCA = LCA(root.right, p, q);

        if (leftLCA == null) return rightLCA;
        if (rightLCA == null) return leftLCA;
        return root;
    }

    public static void assignParents(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        map.put(root, null);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                map.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                map.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }

    public static TreeNode startNode(TreeNode root, int startValue) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.val == startValue) return curr;
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
        return null;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        assignParents(root, map);
        TreeNode sNode = startNode(root, startValue);
        TreeNode lca = LCA(root, startValue, destValue);

        StringBuilder upPath = new StringBuilder();
        while (sNode != lca) {
            upPath.append('U');
            sNode = map.get(sNode);
        }

        StringBuilder downPath = new StringBuilder();
        getLCATODEST(lca, destValue, new StringBuilder(), downPath);

        return upPath.toString() + downPath.toString();
    }

    public static boolean getLCATODEST(TreeNode root, int destValue, StringBuilder path, StringBuilder result) {
        if (root == null) return false;
        if (root.val == destValue) {
            result.append(path.toString());
            return true;
        }

        path.append('L');
        if (getLCATODEST(root.left, destValue, path, result)) return true;
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        if (getLCATODEST(root.right, destValue, path, result)) return true;
        path.deleteCharAt(path.length() - 1);

        return false;
    }
}
