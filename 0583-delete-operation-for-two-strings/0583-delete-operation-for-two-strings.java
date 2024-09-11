class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        return n+m-2*longestCommonSubsequence(word1,word2);
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