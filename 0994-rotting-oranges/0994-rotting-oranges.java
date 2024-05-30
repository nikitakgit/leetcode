class Pair{
    int r;
    int c;
    int time;
    
    Pair(int r,int c,int time)
    {
        this.r=r;
        this.c=c;
        this.time=time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        int[][] vis=new int[n][m];
        int cntfresh=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1)
                {
                    cntfresh++;
                }
            }
        }
        
        int tm=0;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        
        int cnt=0;
        while(!q.isEmpty())
        {
            Pair curr=q.poll();
            int pr=curr.r;
            int pc=curr.c;
            int t=curr.time;
            tm=Math.max(tm,t);
            for(int i=0;i<4;i++)
            {
                int nr=pr+drow[i];
                int nc=pc+dcol[i];
                
                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 && grid[nr][nc]==1)
                {
                    q.add(new Pair(nr,nc,t+1));
                    vis[nr][nc]=2;
                    cnt++;
                }
            }
        }
        if(cnt!=cntfresh) return -1;
        return tm;
    }
    
}