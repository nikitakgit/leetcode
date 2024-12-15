class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n=candidates.length;
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        helper(0,candidates,n,target,ans,ds);
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
            if(i!=ind && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) break;
            ds.add(candidates[i]);
            helper(i+1,candidates,n,target-candidates[i],ans,ds);
            ds.remove(ds.size()-1);
        }
    }
}