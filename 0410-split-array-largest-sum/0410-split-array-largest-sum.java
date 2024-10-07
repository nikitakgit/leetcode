class Solution {
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        if(n<k) return -1;
        int mini=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            mini=Math.max(mini,nums[i]);
            sum+=nums[i];
        }
        int low=mini,high=sum;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int noOfPar=noOfPartition(nums,mid);
            if(noOfPar>k) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
    public int noOfPartition(int[] arr,int pages)
    {
        int partition=1,pagesStudent=0;
        for(int i=0;i<arr.length;i++)
        {
            if(pagesStudent+arr[i]<=pages)
            {
                pagesStudent+=arr[i];
            }else{
                partition++;
                pagesStudent=arr[i];
            }
        }
        return partition;
    }
}