class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        int n=candidates.length;
        helper(0,candidates,ans,ds,n,target);
        return ans;
    }
    public void helper(int ind,int[] candidates,List<List<Integer>> ans,List<Integer> ds,int n,int target)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=ind;i<candidates.length;i++)
        {
            if(i!=ind && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) break;
            
            ds.add(candidates[i]);
            helper(i+1,candidates,ans,ds,n,target-candidates[i]);
            ds.remove(ds.size()-1);
        }
    }
}