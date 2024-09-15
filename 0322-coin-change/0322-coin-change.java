class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int[] a:dp)
        {
            Arrays.fill(a,-1);
        }
        int ans=helper(n-1,coins,amount,dp);
        if(ans>=(int)Math.pow(10,9)) return -1;
        else return ans;
    }
    public int helper(int i,int[] coins,int amount,int[][] dp)
    {
        if(i==0)
        {
            if(amount%coins[i]==0) return amount/coins[i];
            else return (int)Math.pow(10,9);
        }
        if(dp[i][amount]!=-1) return dp[i][amount];
        int notTake=helper(i-1,coins,amount,dp);
        int take=Integer.MAX_VALUE;
        if(coins[i]<=amount)
        {
            take=1+helper(i,coins,amount-coins[i],dp);
        }
        return dp[i][amount]=Math.min(take,notTake);
    }
}

