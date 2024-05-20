class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums,0,0);
    }
    public int helper(int[] nums,int level,int currXor)
    {
        if(level==nums.length) return currXor;
        int include=helper(nums,level+1,currXor^nums[level]);
        int exclude=helper(nums,level+1,currXor);
        return include+exclude;
    }
}