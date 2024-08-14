class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][k+1];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<2;j++)
            {
                for(int m=0;m<k+1;m++)
                {
                    dp[i][j][m]=-1;
                }
            }
        }
       return helper(0,1,k,prices,n,dp);
    }
    public int helper(int i,int buy,int cap,int[] prices,int n,int[][][] dp)
    {
        if(cap==0) return 0;
        if(i==n) return 0;
        if(dp[i][buy][cap]!=-1) return dp[i][buy][cap];
        int profit=0;
        if(buy==1)
        {
            profit= Math.max(-prices[i]+helper(i+1,0,cap,prices,n,dp), 0+helper(i+1,1,cap,prices,n,dp));
        }else{
            profit= Math.max(prices[i]+helper(i+1,1,cap-1,prices,n,dp),0+helper(i+1,0,cap,prices,n,dp));
        }
        return dp[i][buy][cap]=profit;
    
    }
}