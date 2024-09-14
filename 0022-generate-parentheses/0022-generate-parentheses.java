class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        helper(0,0,n,"",ans);
        return ans;
    }  
    public void helper(int opn,int close,int n,String s,List<String> ans)
    {
        if(opn==close && opn+close==2*n)
        {
            ans.add(s);
            return;
        }
        
        if(opn<n)
        {
            helper(opn+1,close,n,s+'(',ans);
        }
        if(close<opn)
        {
            helper(opn,close+1,n,s+')',ans);
        }
    }
}
    
  