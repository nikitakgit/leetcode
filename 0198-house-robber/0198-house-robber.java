class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
       return helper(nums.length-1,nums,dp);
    }
    public int helper(int i,int[] nums,int[] dp)
    {
        if(i==0) return nums[0];
        if(dp[i]!=-1) return dp[i];
        int pick=nums[i];
        int notpick=0+helper(i-1,nums,dp);
        if(i>1)
        {
            pick+=helper(i-2,nums,dp);
        }
        return dp[i]=Math.max(pick,notpick);
    }
}