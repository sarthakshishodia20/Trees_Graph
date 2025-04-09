class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;//edges se 1  jyada hi honge node hmesha
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for (int i = 1; i <= n; i++) {
            if (adj.get(i).size() == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
