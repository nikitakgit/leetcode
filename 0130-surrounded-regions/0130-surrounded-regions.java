class Solution {
   
    public void dfs(int r,int c,int[][] vis,char[][] board,int[] delrow,int[] delcol)
    {
        vis[r][c]=1;
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<4;i++)
        {
            int nrow=r+delrow[i];
            int ncol=c+delcol[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 && board[nrow][ncol]=='O')
            {
                dfs(nrow,ncol,vis,board,delrow,delcol);
            }
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
      int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        int[][] vis=new int[m][n];
        
        for(int j=0;j<n;j++)
        {
            if(vis[0][j]==0 && board[0][j]=='O')
            {
                dfs(0,j,vis,board,delrow,delcol);
            }
            if(vis[m-1][j]==0 && board[m-1][j]=='O')
            {
                dfs(m-1,j,vis,board,delrow,delcol);
            }
        }
        for(int i=0;i<m;i++)
        {
            if(vis[i][0]==0 && board[i][0]=='O')
            {
                dfs(i,0,vis,board,delrow,delcol);
            }
            if(vis[i][n-1]==0 && board[i][n-1]=='O')
            {
                dfs(i,n-1,vis,board,delrow,delcol);
            }
        }
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(vis[i][j]==0 && board[i][j]=='O')
                {
                    board[i][j]='X';
                }
            }
        }
        
    }
}