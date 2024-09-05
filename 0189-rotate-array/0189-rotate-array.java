class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        int[] temp=new int[n];
        for(int i=0;i<nums.length;i++)
        {
            int k1=(i+k)%n;
            temp[k1]=nums[i];
        }
        for(int i=0;i<n;i++)
        {
            nums[i]=temp[i];
        }
    }
}