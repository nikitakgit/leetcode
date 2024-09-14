class Solution {
    public int longestSubarray(int[] nums) {
        int max=0,cnt=0,maxCnt=0;
        for(int i=0;i<nums.length;i++)
        {
            max=Math.max(max,nums[i]);
        }
        for(int i=0;i<nums.length;i++)
        {
            if(max==nums[i])
            {
                cnt++;
            }else{
                maxCnt=Math.max(maxCnt,cnt);
                cnt=0;
            }
        }
        maxCnt=Math.max(maxCnt,cnt);
        if(maxCnt==0) return 1;
        return maxCnt;
    }
}



