public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for(int j = 2; j <= n; j++){
            for(int i = j - 1; i > 0; i--){
                int globalMin = Integer.MAX_VALUE;
                for(int k = i + 1; k < j; k++){
                    int localMax = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                    globalMin = Math.min(globalMin, localMax);
                }
                dp[i][j] = i + 1 == j ? i : globalMin;
            }
        }
        return dp[1][n];
    }
}