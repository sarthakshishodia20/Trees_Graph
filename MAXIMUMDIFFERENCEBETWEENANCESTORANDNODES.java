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
    public int maxAncestorDiff(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> currentPath=new ArrayList<>();
        findAllPaths(result,currentPath,root);
        int maxDiff=Integer.MIN_VALUE;
        for(List<Integer> path:result){
            Collections.sort(path);
            maxDiff=Math.max(maxDiff,Math.abs(path.get(0)-path.get(path.size()-1)));
        }
        return maxDiff;
    }
     public static void findAllPaths(List<List<Integer>> result, List<Integer> path, TreeNode root) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        } else {
            findAllPaths(result, path, root.left);
            findAllPaths(result, path, root.right);
        }

        path.remove(path.size() - 1); 
    }
}
