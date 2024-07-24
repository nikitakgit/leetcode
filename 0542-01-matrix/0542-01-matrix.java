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
        int[][] dist=new int[m][n];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    vis[i][j]=1;
                    q.add(new Pair(i,j,0));
                }else{
                    vis[i][j]=0;
                }
            }
        }
        
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            int row=p.f;
            int col=p.s;
            int step=p.t;
            
            dist[row][col]=step;
            for(int i=0;i<4;i++)
            {
                int nrow=row+delRow[i];
                int ncol=col+delCol[i];
                
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0)
                {
                    vis[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol,step+1));
                }
            }
        }
        return dist;
    }
}