class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        
        int n=rowSum.length;
        int m=colSum.length;
        int[][] output=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int mini=Math.min(rowSum[i],colSum[j]);
                output[i][j]=mini;
                rowSum[i]-=mini;
                colSum[j]-=mini;
            }
        }
        return output;
    }
}