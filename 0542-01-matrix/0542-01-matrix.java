class Pair{
    int f;
    int s;
    int t;
    Pair(int f,int s,int t)
    {
        this.f=f;
        this.s=s;
        this.t=t;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
       int m=mat.length;
        int n=mat[0].length;
        int[][] vis=new int[m][n];
        int[][] dis=new int[m][n];
        
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
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
        
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            int r=p.f;
            int c=p.s;
            int step=p.t;
            
            dis[r][c]=step;
            for(int i=0;i<4;i++)
            {
                int nr=r+dr[i];
                int nc=c+dc[i];
                
                if(nr>=0 && nr<m && nc>=0 && nc<n && vis[nr][nc]==0)
                {
                    vis[nr][nc]=1;
                    q.add(new Pair(nr,nc,step+1));
                }
            }
            
        }
        return dis;
    }
}