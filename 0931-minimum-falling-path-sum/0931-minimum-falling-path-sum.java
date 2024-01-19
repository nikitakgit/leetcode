class Solution {
    Integer[][] dp;
    public int minFallingPathSum(int[][] matrix) {
        dp=new Integer[matrix.length+1][matrix.length+1];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++)
        {
            min=Math.min(min,matrix[0][i]+solve(1,matrix,matrix.length,i)); 
        }
        return min;
       
    }
    public int solve(int row,int[][] matrix,int n,int col)
    {
        if(row==n)
        {
            return 0;
        }
        if(dp[row][col]!=null)
        {
            return dp[row][col];
        }
        int left=col-1;
        int right=col+1;
        if(left<0 && right>=n)
        {
            return dp[row][col]=matrix[row][col]+solve(row+1,matrix,n,col);
        }else if(left<0)
        {
           return dp[row][col]=Math.min(matrix[row][col]+solve(row+1,matrix,n,col),
                                        matrix[row][col+1]+solve(row+1,matrix,n,col+1)); 
        }else if(right>=n)
        {
            return dp[row][col]=Math.min(matrix[row][col]+solve(row+1,matrix,n,col),
                                         matrix[row][col-1]+solve(row+1,matrix,n,col-1)); 
        }
        
        return dp[row][col]= 
            Math.min(
            matrix[row][col]+solve(row+1,matrix,n,col),
            Math.min(matrix[row][col+1]+solve(row+1,matrix,n,col+1),
                                        matrix[row][col-1]+solve(row+1,matrix,n,col-1))); 
    }
}