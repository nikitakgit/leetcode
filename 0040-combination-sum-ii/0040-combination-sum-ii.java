class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        helper(0,candidates.length,candidates,target,new ArrayList<>(),ans);
        return ans;
    }
    public void helper(int ind,int n,int[] candidates,int target,List<Integer> ds,List<List<Integer>> ans)
    {
        
            if(target==0) {
                ans.add(new ArrayList<>(ds));
            return;
            }
        
        
        for(int i=ind;i<n;i++)
        {
            if(i>ind && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) break;
            
            ds.add(candidates[i]);
            helper(i+1,n,candidates,target-candidates[i],ds,ans);
            ds.remove(ds.size()-1);
        }
        
    }
}