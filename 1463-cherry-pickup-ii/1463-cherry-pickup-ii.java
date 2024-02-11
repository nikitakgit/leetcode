class Solution {
    public int helper(int[][] grid,int r,int c1,int c2,int[][][] dp)
    {
        if(r==grid.length) return 0;
        if(c1<0 || c2<0 || c1>=grid[0].length || c2>=grid[0].length) return Integer.MIN_VALUE;
        if(dp[r][c1][c2]!=-1) return dp[r][c1][c2];
        int ans=grid[r][c1]+grid[r][c2];
        if(c1==c2)
        {
            ans-=grid[r][c1];
        }
        return dp[r][c1][c2]=Math.max(helper(grid,r+1,c1-1,c2,dp),
                                     Math.max(helper(grid,r+1,c1-1,c2-1,dp),
                                     Math.max(helper(grid,r+1,c1-1,c2+1,dp),
                                     Math.max(helper(grid,r+1,c1,c2,dp),
                                     Math.max(helper(grid,r+1,c1,c2-1,dp),
                                     Math.max(helper(grid,r+1,c1,c2+1,dp),
                                     Math.max(helper(grid,r+1,c1+1,c2,dp),
                                     Math.max(helper(grid,r+1,c1+1,c2-1,dp),
                                     helper(grid,r+1,c1+1,c2+1,dp)))))))))+ans;
    }
    public int cherryPickup(int[][] grid) {
        int[][][] dp=new int[grid.length][grid[0].length][grid[0].length];
        for(int[][] row:dp)
        {
            for(int[] col:row)
            {
                Arrays.fill(col,-1);
            }
        }
        
        return helper(grid,0,0,grid[0].length-1,dp);
    }
}



