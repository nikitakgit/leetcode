class Pair{
    int r;
    int c;
    int t;
    Pair(int r,int c,int t)
    {
        this.r=r;
        this.c=c;
        this.t=t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int cntFresh=0;
        int[][] vis=new int[m][n];
        
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1)
                {
                    cntFresh++;
                }
            }
        }
        
        int tm=0;
        int cnt=0;
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            int r=p.r;
            int c=p.c;
            int t=p.t;
            
            tm=Math.max(tm,t);
            int[] dr={-1,0,1,0};
            int[] dc={0,1,0,-1};
            
            for(int i=0;i<4;i++)
            {
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n && vis[nr][nc]==0 && grid[nr][nc]==1)
                {
                    q.add(new Pair(nr,nc,t+1));
                    vis[nr][nc]=2;
                    cnt++;
                }
            }
        }
        
        return cnt==cntFresh?tm:-1;
    }
}