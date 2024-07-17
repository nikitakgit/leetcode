class Solution {
    public void dfs(int r,int c,int[][] img,int[][] ans, int newColor,int[] dr,int[] dc,int iniColor)
    {
        ans[r][c]=newColor;
        int n=img.length;
        int m=img[0].length;
        for(int i=0;i<4;i++)
        {
            int nr=r+dr[i];
            int nc=c+dc[i];
            
            if(nr>=0 && nr<n && nc>=0 && nc<m && img[nr][nc]==iniColor && ans[nr][nc]!=newColor)
            {
                dfs(nr,nc,img,ans,newColor,dr,dc,iniColor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor=image[sr][sc];
        int[][] ans=image;
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        dfs(sr,sc,image,ans,color,dr,dc,iniColor);
        return ans;
    }
}