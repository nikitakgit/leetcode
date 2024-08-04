class Solution {
    public int coinChange(int[] coins, int amount) {
  int[][] dp=new int[coins.length][amount+1];
        for(int[] row:dp)
        {
            Arrays.fill(row,-1);
        }
        int ans= f(coins.length-1,coins,amount,dp);
        if(ans>=(int)Math.pow(10,9))
        {
            return -1;
        }
        return ans;
    }
    
    public int f(int i,int[] coins,int target,int[][] dp)
    {   
        
        if(i==0)
        {
            if(target%coins[i]==0)
            {
                return target/coins[0];
            }
            else return (int)Math.pow(10,9);
        }
        if(dp[i][target]!=-1)
        {
            return dp[i][target];
        }
        int notTake=0+f(i-1,coins,target,dp);
        int Take=Integer.MAX_VALUE;
        if(coins[i]<=target)
        {
            Take=1+f(i,coins,target-coins[i],dp);
        }
        
         dp[i][target]=Math.min(Take,notTake);
        return dp[i][target];
        
    
    }
}