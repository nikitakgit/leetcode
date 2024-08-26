class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> ans=new ArrayList<>();
        helper(0,candidates.length,candidates,new ArrayList<>(),ans,target);
        return ans;
   }
    public void helper(int i,int n,int[] candidates,List<Integer> ds,List<List<Integer>> ans,int target)
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
            helper(i,n,candidates,ds,ans,target-candidates[i]);
            ds.remove(ds.size()-1);
        }
        
        helper(i+1,n,candidates,ds,ans,target);
    }
}

