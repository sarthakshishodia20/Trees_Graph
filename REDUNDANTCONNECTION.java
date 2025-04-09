class Solution {
    static class DSU {
        private int[] rank;
        private int[] parent;
        public DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); 
            }
            return parent[x];
        }
        public boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return false;
            if (rank[px] > rank[py]) {
                parent[py] = px;
            } else if (rank[px] < rank[py]) {
                parent[px] = py;
            } else {
                parent[px] = py;
                rank[py]++;
            }
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if (!dsu.union(x, y)) {
                return new int[]{x, y};
            }
        }
        return new int[]{};
    }
}
