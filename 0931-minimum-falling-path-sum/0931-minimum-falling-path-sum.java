class Solution {
    public int minFallingPathSum(int[][] matrix) {
     int n = matrix.length;
        int[][] dp = new int[n][n];

        // Initialize the first row of dp with the first row of the matrix
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Fill the dp table row by row
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int ld = j > 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int up = dp[i - 1][j];
                int rd = j < n - 1 ? dp[i - 1][j + 1] : Integer.MAX_VALUE;
                dp[i][j] = matrix[i][j] + Math.min(ld, Math.min(up, rd));
            }
        }

        // Find the minimum value in the last row of dp
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            mini = Math.min(mini, dp[n - 1][j]);
        }
        return mini;
    }
}