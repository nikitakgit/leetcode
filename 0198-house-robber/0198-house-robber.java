class Solution {
    public int rob(int[] nums) {
       int n=nums.length;
       int[] dp=new int[n];
        Arrays.fill(dp,-1);
       return helper(n-1,nums,dp);
    }
    public int helper(int i,int[] nums,int[] dp)
    {
        if(i==0) return nums[i];
        if(dp[i]!=-1) return dp[i];
        int take=nums[i];
        int notTake=0+helper(i-1,nums,dp);
        if(i>1)
        {
            take+=helper(i-2,nums,dp);
        }
        return dp[i]=Math.max(take,notTake);
    }
}