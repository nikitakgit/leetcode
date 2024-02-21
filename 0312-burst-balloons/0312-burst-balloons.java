class Solution {
    public int helper(int i,int j,int[] nums,int[][] dp)
    {
        if(i>j) return 0;
        int maxi=Integer.MIN_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int ind=i;ind<=j;ind++)
        {
            int cost=(nums[i-1]*nums[ind]*nums[j+1])+helper(i,ind-1,nums,dp)+helper(ind+1,j,nums,dp);
            maxi=Math.max(maxi,cost);
        }
        return dp[i][j]=maxi;
    }
    public int maxCoins(int[] nums) {
        int[] arr=new int[nums.length+2];
        arr[0]=1;
        arr[arr.length-1]=1;
        for(int i=1;i<arr.length-1;i++)
        {
            arr[i]=nums[i-1];
        }
        int[][] dp=new int[nums.length+1][nums.length+1];
        for(int[] row:dp)
        {
            Arrays.fill(row,-1);
        }
        return helper(1,nums.length,arr,dp);
    }
    
}