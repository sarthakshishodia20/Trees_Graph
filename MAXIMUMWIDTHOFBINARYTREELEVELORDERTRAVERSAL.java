class Solution {
    static class Pair {
        TreeNode root;
        long index;
        public Pair(TreeNode root, long index) {
            this.root = root;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        int ans = 0;
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            int n = q.size();
            long minIndex = q.peek().index;
            long start = 0, end = 0;
            for (int i = 0; i < n; i++) {
                Pair p = q.poll();
                long idx = p.index - minIndex; 
                if (i == 0) start = idx;
                if (i == n - 1) end = idx;
                if (p.root.left != null) {
                    q.add(new Pair(p.root.left, 2 * idx + 1));
                }
                if (p.root.right != null) {
                    q.add(new Pair(p.root.right, 2 * idx + 2));
                }
            }
            ans = Math.max(ans, (int) (end - start + 1));
        }
        return ans;
    }
}
