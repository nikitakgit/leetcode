class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];
        for(int[] row:dp)
        {
            Arrays.fill(row,-1);
        }
        return helper(0,-1,n,nums,dp);
    }
    public int helper(int i,int prev,int n,int[] nums,int[][] dp)
    {
        if(i==n) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int len=0+helper(i+1,prev,n,nums,dp);
        if(prev==-1 || nums[prev]<nums[i])
        {
            len=Math.max(len,1+helper(i+1,i,n,nums,dp));
        }
        return dp[i][prev+1]=len;
    }
}