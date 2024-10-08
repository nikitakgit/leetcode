class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for(int[] a:dp)
        {
            Arrays.fill(a,-1);
        }
        return helper(0,1,fee,prices,n,dp);
    }
    public int helper(int i,int buy,int fee,int[] prices,int n,int[][] dp)
    {
        if(i==n) return 0;
        int profit=0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        if(buy==1)
        {
            profit=Math.max(-prices[i]+helper(i+1,0,fee,prices,n,dp),0+helper(i+1,1,fee,prices,n,dp));
        }else{
            profit=Math.max(prices[i]-fee+helper(i+1,1,fee,prices,n,dp),0+helper(i+1,0,fee,prices,n,dp));
        }
        return dp[i][buy]=profit;
    }
}