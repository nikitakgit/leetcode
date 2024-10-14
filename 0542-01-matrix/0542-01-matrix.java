class Pair{
    int r;
    int c;
    int d;
    Pair(int r,int c,int d)
    {
        this.r=r;
        this.c=c;
        this.d=d;
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
            int r=p.r;
            int c=p.c;
            int d=p.d;
            dis[r][c]=d;
            
            for(int i=0;i<4;i++)
            {
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0 && nc>=0 && nr<m && nc<n && vis[nr][nc]==0)
            {
                q.add(new Pair(nr,nc,d+1));
                vis[nr][nc]=1;
            }
            }
        }
        return dis;
    }
}