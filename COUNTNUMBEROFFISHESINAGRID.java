class Solution {
    // same as max Area of Islands leetcode 695
    public int findMaxFish(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int n = grid.length;
        int m = grid[0].length;
        int maxFish = 0;
        int[] dx = {-1, 0, +1, 0};
        int[] dy = {0, +1, 0, -1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0 && visited[i][j] == 0) {
                    maxFish = Math.max(maxFish, dfs(grid, visited, i, j, dx, dy));
                }
            }
        }
        return maxFish;
    }

    public static int dfs(int[][] grid, int[][] visited, int row, int col, int[] dx, int[] dy) {
        visited[row][col] = 1;
        int fishes = grid[row][col]; 
        for (int k = 0; k < 4; k++) {
            int nrow = row + dx[k];
            int ncol = col + dy[k];
            if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && visited[nrow][ncol] == 0 && grid[nrow][ncol] > 0) {
                fishes += dfs(grid, visited, nrow, ncol, dx, dy);
            }
        }
        return fishes;
    }
}
