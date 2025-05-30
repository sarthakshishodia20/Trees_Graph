public class CoinChangeTabulation {
    public static void main(String[] args) {
        int[] coins={1,2,3};
        int amount=4;
        System.out.println(coinChange(coins,amount));
    }
   public static int coinChange(int[] coins, int amount) {
            int n = coins.length;
            int W = amount;
            int[][] dp = new int[n + 1][W + 1];
            for (int i = 0; i < n + 1; i++) {
                dp[i][0] = 1;
            }
            for (int j = 0; j < W + 1; j++) {
                dp[0][j] = 0;
            }
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < W + 1; j++) {
                    if (coins[i - 1] <= j) {
                        dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            
            return dp[n][W];
        }
    
    
}
