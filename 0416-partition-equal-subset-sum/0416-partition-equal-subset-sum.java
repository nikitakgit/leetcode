class Solution {
    public boolean canPartition(int[] nums) {
        int totSum=0;
        for(int i=0;i<nums.length;i++)
        {
            totSum+=nums[i];
        }
        
        if(totSum%2==1) return false;
        int target=totSum/2;
        
        if(isSubsetSum(nums.length,nums,target))
        {
            return true;
        }
        return false;
        
    }
    public Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        Boolean[][] dp=new Boolean[N][sum+1];
        
        return helper(N-1,arr,sum,dp);
    }
    public boolean helper(int i,int[] arr,int sum,Boolean[][] dp)
    {
        if(sum==0) return true;
        if(i==0) return arr[i]==sum;
        if(dp[i][sum]!=null) return dp[i][sum];
        boolean notTake=helper(i-1,arr,sum,dp);
        boolean take=false;
        if(arr[i]<=sum)
        {
            take=helper(i-1,arr,sum-arr[i],dp);
        }
        return dp[i][sum]=take || notTake;
    }
}