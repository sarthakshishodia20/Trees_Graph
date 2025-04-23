class Solution {
    public int mostFrequentPrime(int[][] mat) {
        HashMap<Integer, Integer> mapFrequency = new HashMap<>();
        int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        int num = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                for (int k = 0; k < 8; k++) {
                    dfs(mat, i, j, num, dx, dy, k, mapFrequency);
                }
            }
        }
        int result = -1;
        int maxFrequency = -1;
        for (Map.Entry<Integer, Integer> entry : mapFrequency.entrySet()) {
            int number = entry.getKey();
            int freq = entry.getValue();
            if (isPrime(number) && (freq > maxFrequency || (freq == maxFrequency && number > result))) {
                result = number;
                maxFrequency = freq;
            }
        }
        return result;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
    public static void dfs(int[][] matrix, int row, int col, int currnumber,
                           int[] dx, int[] dy, int direction, HashMap<Integer, Integer> map) {
        int n = matrix.length;
        int m = matrix[0].length;
        currnumber = currnumber * 10 + matrix[row][col];
        if (currnumber > 10) {
            map.put(currnumber, map.getOrDefault(currnumber, 0) + 1);
        }
        int nrow = row + dx[direction];
        int ncol = col + dy[direction];
        if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
            dfs(matrix, nrow, ncol, currnumber, dx, dy, direction, map);
        }
    }
}
