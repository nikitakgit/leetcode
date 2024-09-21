class Solution {
    public int[] searchRange(int[] nums, int target) {
       int[] ans={-1,-1};
        ans[0]=findFirstAndLast(nums,target,true);
        if(ans[0]!=-1)
        {
            ans[1]=findFirstAndLast(nums,target,false);
        }
        return ans;
    }
    public int findFirstAndLast(int[] nums,int target,boolean findFirst)
    {
        int l=0;
        int h=nums.length-1;
        int ans=-1;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(nums[mid]<target)
            {
                l=mid+1;
            }else if(nums[mid]>target)
            {
                h=mid-1;
            }else{
                ans=mid;
                if(findFirst)
                {
                    h=mid-1;
                }else{
                    l=mid+1;
                }
            }
        }
        return ans;
    }
}