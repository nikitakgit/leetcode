class Solution {
    public List<List<Integer>> subsets(int[] nums) {
     List<List<Integer>> ans=new ArrayList<>();
        helper(0,nums,nums.length,ans,new ArrayList<>());
        return ans;
    }
    public void helper(int i,int[] nums,int n,List<List<Integer>> ans,List<Integer> ds)
    {
        if(i==n)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        ds.add(nums[i]);
        helper(i+1,nums,n,ans,ds);
        ds.remove(ds.size()-1);
        
        helper(i+1,nums,n,ans,ds);
    }
}
