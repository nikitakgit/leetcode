class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for(int[] rows:dp)
        {
            Arrays.fill(rows,-1);
        }
        return helper(0,1,prices,n,dp);
    }
    public int helper(int i,int buy,int[] prices,int n,int[][] dp)
    {   int profit=0;
        if(i==n) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        if(buy==1)
        {
           profit=Math.max(-prices[i]+helper(i+1,0,prices,n,dp),0+helper(i+1,1,prices,n,dp)); 
        }else{
            profit=Math.max(prices[i]+helper(i+1,1,prices,n,dp),0+helper(i+1,0,prices,n,dp));
        }
     return dp[i][buy]=profit;
    }
}