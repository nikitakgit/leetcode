class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[][] dp=new int[m][n];
        for(int[] rows:dp)
        {
            Arrays.fill(rows,-1);
        }
        return helper(m-1,n-1,text1,text2,dp);
    }
    public int helper(int i,int j,String t1,String t2,int[][] dp)
    {
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        
        //if character matches
        if(t1.charAt(i)==t2.charAt(j))
        {
            return dp[i][j]=1+helper(i-1,j-1,t1,t2,dp);
        }
        
        //if character not matches
        return dp[i][j]=Math.max(helper(i-1,j,t1,t2,dp),helper(i,j-1,t1,t2,dp));
    }
}