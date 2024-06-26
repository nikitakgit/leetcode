class Solution {
    public int jump(int[] nums) {
        int jump=0;
        int l=0;
        int r=0;
        int n=nums.length;
        while(r<n-1)
        {
            int farthest=0;
            for(int ind=l;ind<=r;ind++)
            {
                farthest=Math.max(ind+nums[ind],farthest);
            }
            
            l=r+1;
            r=farthest;
            jump++;
        }
        return jump;
    }
}