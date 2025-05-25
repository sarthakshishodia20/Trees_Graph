class Solution {
    private int endY = -1;
    private int endX = -1;
    public int[][] findFarmland(int[][] grid) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int[] dx = {-1, 0, +1, 0};
        int[] dy = {0, +1, 0, -1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    int startX = i;
                    int startY = j;
                    // private variables reset isliye kre kyuki hrr dfs ke liye new call jaegi or purane wale ka max compare ho skta hai!! important
                    endX = startX;
                    endY = startY;
                    dfs(i, j, grid, visited, dx, dy);
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(startX);
                    list.add(startY);
                    list.add(endX);
                    list.add(endY);
                    result.add(list);
                }
            }
        }
        int[][] ans = new int[result.size()][4];
        int rowIndex = 0;
        for (ArrayList<Integer> list : result) {
            for (int colIndex = 0; colIndex < 4; colIndex++) {
                ans[rowIndex][colIndex] = list.get(colIndex);
            }
            rowIndex++;
        }
        return ans;
    }

    public void dfs(int row, int col, int[][] grid, int[][] visited, int[] dx, int[] dy) {
        visited[row][col] = 1;
        // kyuki dfs kahi bhi jaa skta hai isliye koi guarantee nahi hai ki hmesha last row hi sbse last mein visit ho jsiki vajah se smaller row bhi update ho skti hai isliye atmost case mein max function use kro instead
        endX = Math.max(endX, row);
        endY = Math.max(endY, col);
        for (int k = 0; k < 4; k++) {
            int nrow = row + dx[k];
            int ncol = col + dy[k];
            if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, grid, visited, dx, dy);
            }
        }
    }
}
