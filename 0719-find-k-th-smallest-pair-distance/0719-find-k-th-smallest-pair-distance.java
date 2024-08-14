class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int mini=0;
        int maxi=nums[nums.length-1]-nums[0];
        while(mini<maxi)
        {
            int mid=mini+(maxi-mini)/2;
            int pairsCnt=cntPairWithinDist(nums,mid);
            if(pairsCnt<k)
            {
                mini=mid+1;
            }else{
                maxi=mid;
            }
        }
        return mini;
    }
    public int cntPairWithinDist(int[] nums,int targetDist)
    {
        int cnt=0;
        int left=0;
        for(int right=1;right<nums.length;right++)
        {
            while(nums[right]-nums[left]>targetDist)
            {
                left++;
            }
            cnt+=right-left;
        }
        return cnt;
    }
}

