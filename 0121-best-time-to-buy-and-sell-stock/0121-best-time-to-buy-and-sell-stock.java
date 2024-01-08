class Solution {
    public int maxProfit(int[] prices) {
       int minCp=Integer.MAX_VALUE;
       int profit=0;
       int profitToday=0;
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]<minCp)
            {
                minCp=prices[i];
            }
            
            profitToday=prices[i]-minCp;
            if(profitToday>profit)
            {
                profit=profitToday;
            }
        }
        return profit;
    }
}
