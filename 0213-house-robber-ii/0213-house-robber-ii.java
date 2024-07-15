class Solution {
    public int rob(int[] valInHouse) {
        ArrayList<Integer> temp1=new ArrayList<>();
        ArrayList<Integer> temp2=new ArrayList<>();
        
        int n=valInHouse.length;
        if(n==1) return valInHouse[0];
        for(int i=0;i<n;i++)
        {
            if(i!=0) temp1.add(valInHouse[i]);
            if(i!=n-1) temp2.add(valInHouse[i]);
        }
        
        int[] arr1=new int[temp1.size()];
        int[] arr2=new int[temp2.size()];
        for(int i=0;i<temp1.size();i++)
        {
            arr1[i]=temp1.get(i);
        }
        for(int i=0;i<temp2.size();i++)
        {
            arr2[i]=temp2.get(i);
        }
        int[] dp1=new int[arr1.length];
        int[] dp2=new int[arr2.length];
        
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        return Math.max(helper(arr1.length-1,arr1,dp1),helper(arr2.length-1,arr2,dp2));
    }
    public int helper(int i,int[] nums,int[] dp)
    {
        if(i==0) return nums[0];
        if(dp[i]!=-1) return dp[i];
        int pick=nums[i];
        int notpick=0+helper(i-1,nums,dp);
        if(i>1)
        {
            pick+=helper(i-2,nums,dp);
        }
        return dp[i]=Math.max(pick,notpick);
    }
}