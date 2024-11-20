class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        helper(0,nums,n,ans,ds);
        return ans;
    }
    public void helper(int ind,int[] nums,int n,List<List<Integer>> ans,List<Integer> ds)
    {
        
        ans.add(new ArrayList<>(ds));
           
        for(int i=ind;i<n;i++)
        {
            if(i!=ind && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            helper(i+1,nums,n,ans,ds);
            ds.remove(ds.size()-1);
        }
    }
}