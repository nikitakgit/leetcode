class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
       int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int[] rows:dp)
        {
            Arrays.fill(rows,-1);
        }
        
        return solve(grid,m-1,n-1,dp);
    }
    public int solve(int[][] grid,int i,int j,int[][] dp)
    {
        if(i>=0 && j>=0 && grid[i][j]==1)
        {
            return 0;
        }
        if(i==0 && j==0)
        {
            return 1;
        }
        if(i<0 || j<0)
        {
            return 0;
        }
        
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        
        int up=solve(grid,i-1,j,dp);
        int left=solve(grid,i,j-1,dp);
        
        return dp[i][j]=up+left;
    }
}