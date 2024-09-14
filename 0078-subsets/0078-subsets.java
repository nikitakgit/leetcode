class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> ans=new ArrayList<>();
        helper(0,nums.length,nums,new ArrayList<>(),ans);
        return ans;
    }
    public void helper(int i,int n,int[] nums,List<Integer> ds,List<List<Integer>> ans)
    {
        if(i==n)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        ds.add(nums[i]);
        helper(i+1,n,nums,ds,ans);
        ds.remove(ds.size()-1);
        
        helper(i+1,n,nums,ds,ans);
    }
}
