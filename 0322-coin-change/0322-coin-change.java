class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int[] a:dp)
        {
            Arrays.fill(a,-1);
        }
        int ans=helper(n-1,coins,amount,dp);
        if(ans>=(int)Math.pow(10,9))
        {
            return -1;
        }
        return ans;
    }
    
    public int helper(int ind,int[] coins,int target,int[][] dp)
    {
        if(ind==0)
        {
            if(target%coins[ind]==0) return target/coins[ind];
            else return (int)Math.pow(10,9);
        }
        if(dp[ind][target]!=-1)
        {
            return dp[ind][target];
        }
        int notTake=helper(ind-1,coins,target,dp);
        int take=Integer.MAX_VALUE;
        if(coins[ind]<=target)
        {
            take=1+helper(ind,coins,target-coins[ind],dp);
        }
        return dp[ind][target]=Math.min(take,notTake);
    }
}