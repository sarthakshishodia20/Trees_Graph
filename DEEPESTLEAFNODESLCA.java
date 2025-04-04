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
    static class Pair implements Comparable<Pair> {
        TreeNode node;
        int depth;
        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
        @Override
        public int compareTo(Pair other) {
            return other.depth - this.depth;
        }
    }

    public static void assignParents(TreeNode root, Map<TreeNode, TreeNode> map) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        map.put(root, null);
        while (!q.isEmpty()) {
            TreeNode currNode = q.poll();
            if (currNode.left != null) {
                q.add(currNode.left);
                map.put(currNode.left, currNode);
            }
            if (currNode.right != null) {
                q.add(currNode.right);
                map.put(currNode.right, currNode);
            }
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Map<TreeNode, TreeNode> map = new IdentityHashMap<>();
        assignParents(root, map);
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int D=0;
        while (!q.isEmpty()) {
            int n = q.size();
            // deepest = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode currNode = q.poll();
                pq.add(new Pair(currNode,D));
                // deepest.add(currNode);
                if (currNode.left != null) q.add(currNode.left);
                if (currNode.right != null) q.add(currNode.right);
            }
            D++;
        }
        int maxDepth=pq.peek().depth;
        List<TreeNode> deepest = new ArrayList<>();
        while(!pq.isEmpty()){
            Pair current=pq.poll();
            if(current.depth==maxDepth){
                deepest.add(current.node);
            }
        }
        while (deepest.size() > 1) {
            Set<TreeNode> set = new HashSet<>();
            for (TreeNode node : deepest) {
                TreeNode parent = map.get(node);
                if (parent != null) set.add(parent);
            }
            deepest = new ArrayList<>(set);
        }
        return deepest.get(0);
    }
}
