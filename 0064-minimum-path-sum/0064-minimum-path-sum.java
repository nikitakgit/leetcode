class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        // Initialize dp array with -1
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return helper(m - 1, n - 1, grid, dp);
    }

    public int helper(int i, int j, int[][] grid, int[][] dp) {
        // Out-of-bounds check
        if (i < 0 || j < 0) return Integer.MAX_VALUE;

        // Base case: start point
        if (i == 0 && j == 0) return grid[i][j];

        // Return already computed value
        if (dp[i][j] != -1) return dp[i][j];

        // Recursive calculation
        int up = helper(i - 1, j, grid, dp);
        int left = helper(i, j - 1, grid, dp);

        dp[i][j] = grid[i][j] + Math.min(up, left);

        return dp[i][j];
    }
}