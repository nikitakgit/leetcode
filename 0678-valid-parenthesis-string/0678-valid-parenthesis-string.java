class Solution {
    public boolean checkValidString(String s) {
      
        int n=s.length();
        Boolean[][] dp=new Boolean[n][n];
        return helper(s,0,0,dp);
    }
    public boolean helper(String s,int i,int cnt,Boolean[][] dp)
    {
        boolean result;
        if(cnt<0) return false;
        if(i==s.length())
        {
            return cnt==0;
        }
        if(dp[i][cnt]!=null) return dp[i][cnt];
        if(s.charAt(i)=='(')
        {
            result= helper(s,i+1,cnt+1,dp);
        }
        else if(s.charAt(i)==')')
        {
            result= helper(s,i+1,cnt-1,dp);
        }else{
            
        
        result= helper(s,i+1,cnt+1,dp) || helper(s,i+1,cnt,dp) || helper(s,i+1,cnt-1,dp);
        
        }
        dp[i][cnt]=result;
        return result;
    }
}