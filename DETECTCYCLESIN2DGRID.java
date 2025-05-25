class Solution {
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dx = { -1, 0, +1, 0 };
        int[] dy = { 0, +1, 0, -1 };
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0) {
                    if (dfs(i, j, -1, -1, grid, visited, dx, dy, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean dfs(int row, int col, int parentX, int parentY,
            char[][] grid, int[][] visited, int[] dx, int[] dy, char target) {
        visited[row][col] = 1;
        for (int k = 0; k < 4; k++) {
            int nrow = row + dx[k];
            int ncol = col + dy[k];
            if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length) {
                if (grid[nrow][ncol] == target) {
                    if (visited[nrow][ncol] == 0) {
                        if (dfs(nrow, ncol, row, col, grid, visited, dx, dy, target)) {
                            return true;
                        }
                    } else if (nrow != parentX || ncol != parentY) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
