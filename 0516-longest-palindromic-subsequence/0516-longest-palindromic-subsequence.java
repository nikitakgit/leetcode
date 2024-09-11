class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb=new StringBuilder(s);
        StringBuilder st=sb.reverse();
        String t=st.toString();
        return longestCommonSubsequence(s,t);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[][] dp=new int[m][n];
        for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        
        return helper(m-1,n-1,text1,text2,dp);
    }
    public int helper(int i,int j,String t1,String t2,int[][] dp)
    {
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        
        if(t1.charAt(i)==t2.charAt(j)) return dp[i][j]=1+helper(i-1,j-1,t1,t2,dp);
        return dp[i][j]=Math.max(helper(i,j-1,t1,t2,dp),helper(i-1,j,t1,t2,dp));
    }
}