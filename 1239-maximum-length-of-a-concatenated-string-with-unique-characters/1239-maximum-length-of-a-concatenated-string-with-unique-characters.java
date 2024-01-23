class Solution {
    public int solve(int i,List<String> ans,List<String> arr,Map<String,Integer> dp)
    {
        if(i>=arr.size()) return 0;
        
        StringBuilder cur=new StringBuilder();
        for(String val:ans) cur.append(val);
        
        if(dp.containsKey(cur.toString())) return dp.get(cur.toString());
        
        ans.add(arr.get(i));
        Map<Character,Integer> m=new HashMap<>();
        for(String str:ans)
        {
            for(int j=0;j<str.length();j++)
            {
                m.put(str.charAt(j),m.getOrDefault(str.charAt(j),0)+1);
            }
        }
        
        boolean flag=true;
        for(Map.Entry<Character,Integer> en:m.entrySet())
        {
            if(en.getValue()>1)
            {
                flag=false;
                break;
            }
        }
        
        int take=0,notTake=0;
        if(flag)
        {
            take=arr.get(i).length()+solve(i+1,ans,arr,dp);
        }
        ans.remove(ans.size()-1);
        notTake=solve(i+1,ans,arr,dp);
        
        int res=Math.max(take,notTake);
        dp.put(cur.toString(),res);
        
        return res;
        
    }
        
    public int maxLength(List<String> arr) {
        Map<String, Integer> dp = new HashMap<>();
        List<String> ans = new ArrayList<>();

        return solve(0, ans, arr, dp);
    }

}