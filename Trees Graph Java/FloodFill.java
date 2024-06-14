public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1, sc = 1, newColor = 2;
        
        FloodFill solution = new FloodFill();
        int[][] result = solution.floodFill(image, sr, sc, newColor);

        // Print the result
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, visited, image[sr][sc]);
        return image;
    }

    public static void helper(int[][] image, int sr, int sc, int color, boolean[][] visited, int originalColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || visited[sr][sc] || image[sr][sc] != originalColor) {
            return;
        }
        visited[sr][sc] = true; 
        image[sr][sc] = color; 
        helper(image, sr, sc - 1, color, visited, originalColor);
        helper(image, sr, sc + 1, color, visited, originalColor);
        helper(image, sr - 1, sc, color, visited, originalColor);
        helper(image, sr + 1, sc, color, visited, originalColor);
    }
}
