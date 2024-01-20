class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m][n];
        for(int[] rows:dp)
        {
            Arrays.fill(rows,-1);
        }
        return helper(m-1,n-1,word1,word2,dp);
    }
    public int helper(int i,int j,String word1,String word2,int[][] dp)
    {
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j))
        {
            return dp[i][j]=0+helper(i-1,j-1,word1,word2,dp);
        }
        
        int insert=1+helper(i,j-1,word1,word2,dp);
        int delete=1+helper(i-1,j,word1,word2,dp);
        int replace=1+helper(i-1,j-1,word1,word2,dp);
        
        return dp[i][j]=Math.min(insert,Math.min(delete,replace));
    }
}