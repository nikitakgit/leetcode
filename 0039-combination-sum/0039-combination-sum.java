class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> l=new ArrayList<>();
        helper(0,candidates.length,candidates,target,ans,l);
        return ans;
        
    }
    public void helper(int i,int n,int[] candidates,int target,List<List<Integer>> ans,List<Integer> l)
    {
        if(i==n)
        {
            if(target==0) ans.add(new ArrayList<>(l));
            return;
        }
        if(candidates[i]<=target)
        {
            l.add(candidates[i]);
            helper(i,n,candidates,target-candidates[i],ans,l);
            l.remove(l.size()-1);
        }
        helper(i+1,n,candidates,target,ans,l);
    }
}

