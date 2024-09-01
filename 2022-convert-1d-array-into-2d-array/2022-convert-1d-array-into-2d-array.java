class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] ans=new int[m][n];
        int x=original.length;
        if(x>m*n || x<m*n) return new int[][]{};
        int k=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                ans[i][j]=original[k];
                k++;
                if(k==x) return ans;
            }
        }
        return ans;
    }
}