class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1,high=1000000;
        int ans=high;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(sumOfDiv(nums,mid)<=threshold)
            {
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    public int sumOfDiv(int[] nums,int divisor)
    {
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=Math.ceil((double)nums[i]/(double)divisor);
        }
        return sum;
    }
}