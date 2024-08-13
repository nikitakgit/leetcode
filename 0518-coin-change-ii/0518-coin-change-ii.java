class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int[] a: dp)
        {
            Arrays.fill(a,-1);
        }
        return helper(n-1,coins,amount,dp);
    }
    public int helper(int i,int[] coins,int target,int[][] dp)
    {
        if(target==0)
        {
             
            return 1;
        }
        if(i<0 || target<0) return 0;
        if(dp[i][target]!=-1) return dp[i][target];
        int notTake=helper(i-1,coins,target,dp);
        int Take=0;
        if(coins[i]<=target)
        {
            Take=helper(i,coins,target-coins[i],dp);
        }
        return dp[i][target]=Take+notTake;
    }
}