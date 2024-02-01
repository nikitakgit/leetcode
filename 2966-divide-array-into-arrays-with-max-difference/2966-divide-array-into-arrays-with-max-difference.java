class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] ans=new int[0][0];
        for(int i=0;i+2<nums.length;i++)
        {
            if(i%3==0)
            {
                if(nums[i+2]-nums[i]<=k)
                {
                    int[] triplet={nums[i],nums[i+1],nums[i+2]};
                    ans=Arrays.copyOf(ans,ans.length+1);
                    ans[ans.length-1]=triplet;
                }else{
                    return new int[0][0];
                }
            }
        }
        return ans;
    }
}



