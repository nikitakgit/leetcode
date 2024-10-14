class Solution {
   
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        int[][] ans=image;
        int iniColor=image[sr][sc];
        dfs(sr,sc,ans,color,iniColor,image,dr,dc);
        return ans;
    }
    public void dfs(int r,int c,int[][] ans,int nColor,int iniColor,int[][] image,int[] dr,int[] dc)
    {
        ans[r][c]=nColor;
        int m=image.length;
        int n=image[0].length;
        for(int i=0;i<4;i++)
        {
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0 && nc>=0 && nr<m && nc<n && image[nr][nc]==iniColor && ans[nr][nc]!=nColor)
            {
                
                dfs(nr,nc,ans,nColor,iniColor,image,dr,dc);
            }
        }
    }
}