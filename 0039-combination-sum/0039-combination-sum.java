class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       int n=candidates.length;
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        helper(0,candidates,ans,ds,n,target);
        return ans;
    }
    public void helper(int i,int[] candidates,List<List<Integer>> ans,List<Integer> ds,int n,int target)
    {
        if(i==n)
        {
            if(target==0){
            ans.add(new ArrayList<>(ds));
            
            }
            return;
        }
        
        if(candidates[i]<=target)
        {
            ds.add(candidates[i]);
            helper(i,candidates,ans,ds,n,target-candidates[i]);
            ds.remove(ds.size()-1);
        }
        helper(i+1,candidates,ans,ds,n,target);
    }
}

