class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        helper(0,candidates,candidates.length,target,ans,new ArrayList<>());
        return ans;
    }
    public void helper(int ind,int[] candidates,int n,int target,List<List<Integer>> ans,List<Integer> ds)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=ind;i<n;i++)
        {
            if(i>ind && candidates[i-1]==candidates[i]) continue;
            if(candidates[i]>target) break;
            
            ds.add(candidates[i]);
            helper(i+1,candidates,n,target-candidates[i],ans,ds);
            ds.remove(ds.size()-1);
        }
    }
}