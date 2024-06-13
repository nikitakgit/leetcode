class Solution {
    public int minimizeSum(int[] nums) {
        
        if(nums.length==3) return 0;
        
        Arrays.sort(nums);
        
        //making first 2 element equal
        int a=nums[nums.length-1]-nums[2];
        
        //making last 2 elements equal
        int b=nums[nums.length-3]-nums[0];
        
        //making 1st and last elements equal
        int c=nums[nums.length-2]-nums[1];
        
        return Math.min(a,Math.min(b,c));
    }
}