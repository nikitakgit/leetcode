class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans={-1,-1};
        ans[0]=find(nums,target,true);
        if(ans[0]!=-1)
        {
            ans[1]=find(nums,target,false);
        }
        return ans;
    }
    public int find(int[] nums,int target,boolean findFirst)
    {
        int s=0;
        int e=nums.length-1;
        int ans=-1;
        while(s<=e)
        {
            int mid=s+(e-s)/2;
            if(nums[mid]<target)
            {
                s=mid+1;
            }else if(nums[mid]>target)
            {
                e=mid-1;
            }else{
                ans=mid;
                if(findFirst)
                {
                    e=mid-1;
                }else{
                    s=mid+1;
                }
            }
        }
        return ans;
    }
}