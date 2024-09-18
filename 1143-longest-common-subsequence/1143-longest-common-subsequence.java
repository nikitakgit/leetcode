class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1=text1.length();
        int l2=text2.length();
        int[][] dp=new int[l1][l2];
        for(int[] a:dp)
        {
            Arrays.fill(a,-1);
        }
        return helper(l1-1,l2-1,text1,text2,dp);
    }
    public int helper(int i,int j,String t1,String t2,int[][] dp)
    {
        if(i<0 || j< 0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(t1.charAt(i)==t2.charAt(j))
        {
            return dp[i][j]=1+helper(i-1,j-1,t1,t2,dp);
        }
        return dp[i][j]=Math.max(helper(i-1,j,t1,t2,dp),helper(i,j-1,t1,t2,dp));
    }
}