class Pair{
    int r;
    int c;
    int t;
    
    public Pair(int r,int c,int t)
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
     int[][] vis=new int[m][n];
     
        Queue<Pair> q=new LinkedList<>();
        int cntfresh=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1)
                {
                    cntfresh++;
                }
            }
        }
        
        int tm=0;
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        int cnt=0;
        
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            int r1=p.r;
            int c1=p.c;
            int t1=p.t;
            tm=Math.max(tm,t1);
            for(int i=0;i<4;i++)
            {
                int nr=r1+dr[i];
                int nc=c1+dc[i];
                
                if(nr>=0 && nr<m && nc>=0 && nc<n && vis[nr][nc]==0 && grid[nr][nc]==1)
                {
                    q.add(new Pair(nr,nc,t1+1));
                    vis[nr][nc]=2;
                    cnt++;
                }
            }
        }
        if(cnt!=cntfresh) return -1;
        return tm;
     
    }
    
}