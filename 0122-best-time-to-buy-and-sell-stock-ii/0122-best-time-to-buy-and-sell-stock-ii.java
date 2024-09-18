class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        for(int[] a:dp)
        {
            Arrays.fill(a,-1);
        }
      return helper(0,1,prices.length,prices,dp);
    }
    public int helper(int i,int buy,int n,int[] prices,int[][] dp)
    {
        if(i==n) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        int profit=0;
        if(buy==1)
        {
            profit=Math.max(-prices[i]+helper(i+1,0,n,prices,dp),0+helper(i+1,1,n,prices,dp));
        }else{
            profit=Math.max(prices[i]+helper(i+1,1,n,prices,dp),0+helper(i+1,0,n,prices,dp));
        }
        return dp[i][buy]=profit;
    }
}