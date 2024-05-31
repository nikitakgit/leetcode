class Pair{
    int f;
    int s;
    int t;
    
    public Pair(int f,int s,int t)
    {
        this.f=f;
        this.s=s;
        this.t=t;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        
        int[][] vis=new int[n][m];
        int[][] dist=new int[n][m];
        
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==0)
                {
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }else{
                    vis[i][j]=0;
                }
            }
        }
        
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        
        while(!q.isEmpty())
        {
            Pair curr=q.poll();
            int r=curr.f;
            int c=curr.s;
            int step=curr.t;
            
            dist[r][c]=step;
            for(int i=0;i<4;i++)
            {
                int nr=r+delrow[i];
                int nc=c+delcol[i];
                
                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0)
                {
                    vis[nr][nc]=1;
                    q.add(new Pair(nr,nc,step+1));
                }
            }
        }
        return dist;
    }
}