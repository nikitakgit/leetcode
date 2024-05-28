class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];
        for(int[] a:dp)
        {
            Arrays.fill(a,-1);
        }
        return solve(0,-1,nums,dp);
    }
    public int solve(int i,int prev,int[] nums,int[][] dp)
    {
        if(i==nums.length) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int len=0+solve(i+1,prev,nums,dp);//notTake
        if(prev==-1 || nums[prev]<nums[i])
        {
            len=Math.max(len,1+solve(i+1,i,nums,dp));//take
        }
        return dp[i][prev+1]=len;
    }
}
