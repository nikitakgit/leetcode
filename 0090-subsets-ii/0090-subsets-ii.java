class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
       List<List<Integer>> ans=new ArrayList<>();
        helper(0,nums,nums.length,new ArrayList<>(),ans);
        return ans;
        
    }
    public void helper(int ind,int[] nums,int n,List<Integer> ds,List<List<Integer>> ans)
    {
        ans.add(new ArrayList<>(ds));
        for(int i=ind;i<n;i++)
        {
            if(i!=ind && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            helper(i+1,nums,n,ds,ans);
            ds.remove(ds.size()-1);
        }
    }
}