class Solution {
    boolean isSubIsland;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid2.length;
        int m = grid2[0].length;
        int[][] visited = new int[n][m];
        int[] dx = {-1, 0, +1, 0};
        int[] dy = {0, +1, 0, -1};
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1 && visited[i][j] == 0) {
                    isSubIsland = true; 
                    dfs(i, j, grid1, grid2, visited, dx, dy);
                    if (isSubIsland) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public void dfs(int row, int col, int[][] grid1, int[][] grid2, int[][] visited, int[] dx, int[] dy) {
        visited[row][col] = 1;
        if (grid1[row][col] == 0) {
            isSubIsland = false;
        }
        for (int k = 0; k < 4; k++) {
            int nrow = row + dx[k];
            int ncol = col + dy[k];
            if (nrow >= 0 && nrow < grid2.length && ncol >= 0 && ncol < grid2[0].length && visited[nrow][ncol] == 0 && grid2[nrow][ncol] == 1) {
                dfs(nrow, ncol, grid1, grid2, visited, dx, dy);
            }
        }
    }
}
