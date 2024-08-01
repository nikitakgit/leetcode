class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
       return helper(n,dp);
    }
    public int helper(int i,int[] dp)
    {
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        if(i<0) return 0;
        if(i==0) return 1;
        int one=helper(i-1,dp);
        int two=0;
        if(i>1)
        {
        two=helper(i-2,dp);
        }
        
        return dp[i]=one+two;
    }
}
