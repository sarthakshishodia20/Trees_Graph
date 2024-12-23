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
//  Hmesha minimum number of swap total no. of Cycle se ek kam hi honge it's an observation from this question..
class Solution {
    public int minimumOperations(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int totalSwaps = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode currNode = q.poll();
                level.add(currNode.val);
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
            totalSwaps += countSwap(level);
        }
        return totalSwaps;
    }
    private static int countSwap(List<Integer> list) {
        int n = list.size();
        int[] original = new int[n];
        for (int i = 0; i < n; i++) {
            original[i] = list.get(i);
        }
        int[] sorted = Arrays.copyOf(original, n);
        Arrays.sort(sorted);
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(sorted[i], i);
        }
        boolean[] visited = new boolean[n];
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] || original[i] == sorted[i]) {
                continue;
            }
            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = indexMap.get(original[j]);
                cycleSize++;
            }
            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }
        return swaps;
    }
}
