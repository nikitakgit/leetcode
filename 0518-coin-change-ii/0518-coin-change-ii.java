class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int[] a:dp)
        {
            Arrays.fill(a,-1);
        }
        return helper(n-1,coins,amount,dp);
    }
    public int helper(int i,int[] coins,int amount,int[][] dp)
    {
        if(amount==0)
        {
            return 1;
        }
        
        if(i<0 || amount<0) return 0;
        if(dp[i][amount]!=-1) return dp[i][amount];
        int notTake=helper(i-1,coins,amount,dp);
        int take=0;
        if(coins[i]<=amount)
        {
            take=helper(i,coins,amount-coins[i],dp);
        }
        
        return dp[i][amount]=take+notTake;
    }
}