class Solution {
   
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       int iniCol=image[sr][sc];
        int[][] ans=image;
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        dfs(sr,sc,ans,image,color,dr,dc,iniCol);
        return ans;
    }
    public void dfs(int r,int c,int[][] ans,int[][] image,int newCol,int[] dr,int[] dc,int iniCol)
    {
        ans[r][c]=newCol;
        int n=image.length;
        int m=image[0].length;
        
        for(int i=0;i<4;i++)
        {
            int nr=r+dr[i];
            int nc=c+dc[i];
            
            if(nr>=0 && nr<n && nc>=0 && nc<m && image[nr][nc]==iniCol && ans[nr][nc]!=newCol)
            {
                dfs(nr,nc,ans,image,newCol,dr,dc,iniCol);
            }
        }
    }
}