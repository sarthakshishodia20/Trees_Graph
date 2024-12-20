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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder); 

        List<List<Integer>> result = new ArrayList<>();
        for (int query : queries) {
            int smaller = findClosestSmaller(inorder, query);
            int greater = findClosestGreater(inorder, query);
            result.add(Arrays.asList(smaller, greater));
        }
        return result;
    }
    private void getInorder(TreeNode root, List<Integer> inorder) {
        if (root == null) {
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.val);
        getInorder(root.right, inorder);
    }
    private int findClosestSmaller(List<Integer> inorder, int target) {
        int left = 0, right = inorder.size() - 1;
        int closest = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (inorder.get(mid) <= target) {
                closest = inorder.get(mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return closest;
    }

    private int findClosestGreater(List<Integer> inorder, int target) {
        int left = 0, right = inorder.size() - 1;
        int closest = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (inorder.get(mid) >= target) {
                closest = inorder.get(mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return closest;
    }
}
