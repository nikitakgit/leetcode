class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        int n=candidates.length;
        helper(0,candidates,n,target,ans,ds);
        return ans;
    }
    public void helper(int i,int[] candidates,int n,int target,List<List<Integer>> ans,List<Integer> ds)
    {
        if(i==n)
        {
            if(target==0)
            {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        
        if(candidates[i]<=target)
        {
            ds.add(candidates[i]);
            helper(i,candidates,n,target-candidates[i],ans,ds);
            ds.remove(ds.size()-1);
        }
        helper(i+1,candidates,n,target,ans,ds);
    }
}

