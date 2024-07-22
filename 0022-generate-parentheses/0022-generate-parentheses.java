class Solution {
    public List<String> generateParenthesis(int n) {
     List<String> ans=new ArrayList<>();
        helper(0,0,"",n,ans);
        return ans;
    }
    public void helper(int open,int close,String s,int n,List<String> ans)
    {
        if(open==close && open+close==2*n)
        {
            ans.add(s);
            return;
        }
        
        if(open<n)
        {
            helper(open+1,close,s+"(",n,ans);
        }
        if(close<open)
        {
            helper(open,close+1,s+")",n,ans);
        }
    }  
}
    
  