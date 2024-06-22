class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }
    public int helper(int[] nums,int k)
    {
        if(k<0) return 0;
        int l=0,r=0,sum=0,cnt=0;
        while(r<nums.length)
        {
            sum+=nums[r]%2;
            while(sum>k)
            {
                sum-=nums[l]%2;
                l=l+1;
            }
            cnt+=(r-l+1);
            r++;
        }
        return cnt;
    }
}