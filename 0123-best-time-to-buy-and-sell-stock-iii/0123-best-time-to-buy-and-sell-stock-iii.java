class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][3];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<2;j++)
            {
                for(int k=0;k<3;k++)
                {
                    dp[i][j][k]=-1;
                }
            }
        }
       return helper(0,1,2,prices.length,prices,dp);
    }
    public int helper(int i,int buy,int cap,int n,int[] prices,int[][][] dp)
    {
        if(cap==0) return 0;
        if(i==n) return 0;
        if(dp[i][buy][cap]!=-1) return dp[i][buy][cap];
        int profit=0;
        if(buy==1)
        {
            profit+=Math.max(-prices[i]+helper(i+1,0,cap,n,prices,dp),0+helper(i+1,1,cap,n,prices,dp));
        }else{
            profit+=Math.max(prices[i]+helper(i+1,1,cap-1,n,prices,dp),0+helper(i+1,0,cap,n,prices,dp));
        }
        return dp[i][buy][cap]=profit;
    }
}
