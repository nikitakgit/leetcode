class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0,right=0,sum=0,ans=Integer.MAX_VALUE;
        while(right<nums.length)
        {
            sum+=nums[right];
            if(sum>target)
            {
                ans=Math.min(ans,right-left+1);
                while(sum>target && left<=right)
                {
                    sum-=nums[left];
                    left++;
                    if(sum>target && left<=right)
                    {
                        ans=Math.min(ans,right-left+1);
                    }
                }
            }
            if(sum==target)
            {
                ans=Math.min(ans,right-left+1);
            }
            right++;
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}

 