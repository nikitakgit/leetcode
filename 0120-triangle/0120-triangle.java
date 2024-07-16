class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        int[][] dp=new int[m][m];
        for(int[] a:dp)
        {
            Arrays.fill(a,-1);
        }
        return helper(0,0,triangle,dp);
    }
    public int helper(int i,int j,List<List<Integer>> grid,int[][] dp)
    {
        if(i==grid.size()-1) return grid.get(i).get(j);
        if(dp[i][j]!=-1) return dp[i][j];
        
        int down=grid.get(i).get(j)+helper(i+1,j,grid,dp);
        int dg=grid.get(i).get(j)+helper(i+1,j+1,grid,dp);
        
        return dp[i][j]=Math.min(down,dg);
    }
}