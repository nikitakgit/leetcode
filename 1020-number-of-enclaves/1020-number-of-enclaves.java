
class Pair{
    int f;
    int s;
    Pair(int f,int s)
    {
        this.f=f;
        this.s=s;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
       Queue<Pair> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];
        
        for(int i=0;i<m;i++)
        {
            if(vis[i][0]==0 && grid[i][0]==1)
            {
                q.add(new Pair(i,0));
                vis[i][0]=1;
            }
            if(vis[i][n-1]==0 && grid[i][n-1]==1)
            {
                q.add(new Pair(i,n-1));
                vis[i][n-1]=1;
            }
        }
        
        for(int j=0;j<n;j++)
        {
            if(vis[0][j]==0 && grid[0][j]==1)
            {
                q.add(new Pair(0,j));
                vis[0][j]=1;
            }
            if(vis[m-1][j]==0 && grid[m-1][j]==1)
            {
                q.add(new Pair(m-1,j));
                vis[m-1][j]=1;
            }
        }
        
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            int r=p.f;
            int c=p.s;
            
            for(int i=0;i<4;i++)
            {
                int nr=r+dr[i];
                int nc=c+dc[i];
                
                if(nr>=0 && nr<m && nc>=0 && nc<n && vis[nr][nc]==0 && grid[nr][nc]==1)
                {
                    q.add(new Pair(nr,nc));
                    vis[nr][nc]=1;
                }
            }
        }
        
        int cnt=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(vis[i][j]==0 && grid[i][j]==1)
                {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}