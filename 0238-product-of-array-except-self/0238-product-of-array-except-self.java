class Solution {
    public int[] productExceptSelf(int[] nums) {
       int[] ans=new int[nums.length];
        int n=nums.length;
        ans[0]=1;
        //calculate the left product and store it in ans array
        for(int i=1;i<n;i++)
        {
            ans[i]=ans[i-1]*nums[i-1];
        }
        
        //calculate the right product and update the ans array
        int rightProduct=1;
        for(int i=n-1;i>=0;i--)
        {
            ans[i]=ans[i]*rightProduct;
            rightProduct*=nums[i];
        }
        return ans;
    }
}