class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        List<List<Integer>> ans=new ArrayList<>();
        helper(0,arr,k,n,ans,new ArrayList<>());
        return ans;
    }
    public void helper(int i,int[] arr,int k,int n,List<List<Integer>> ans,List<Integer> ds)
    {
        int cnt=0;
        if(k==0)
        {
            if(n==0) ans.add(new ArrayList<>(ds));
            return;
        }
        if(i==arr.length) return;
        if(arr[i]<=n)
        {
            ds.add(arr[i]);
        helper(i+1,arr,k-1,n-arr[i],ans,ds);
        ds.remove(ds.size()-1);
        }
        
        helper(i+1,arr,k,n,ans,ds);
    }
}