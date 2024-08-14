class Tuple{
    int f,s,t;
    Tuple(int f,int s,int t)
    {
        this.f=f;
        this.s=s;
        this.t=t;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] src={0,0};
        int[] des={m-1,n-1};
        
        if (grid[src[0]][src[1]] == 1 || grid[des[0]][des[1]] == 1) {
            return -1;
        }

        if(src[0]==des[0] && src[1]==des[1]) return 1;
        
        Queue<Tuple> q=new LinkedList<>();
        int[][] dist=new int[m][n];
        for(int[] a:dist)
        {
            Arrays.fill(a,(int)(1e9));
        }
        
        dist[src[0]][src[1]]=1;
        q.add(new Tuple(1,src[0],src[1]));
        int[] dr={-1,-1,-1,0,1,1,1,0};
        int[] dc={-1,0,1,1,1,0,-1,-1};
        
        while(!q.isEmpty())
        {
            Tuple it=q.poll();
            int dis=it.f;
            int r=it.s;
            int c=it.t;
            
            for(int i=0;i<8;i++)
            {
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==0 && dis+1<dist[nr][nc])
                {
                    dist[nr][nc]=dis+1;
                    if(nr==des[0] && nc==des[1]) return dis+1;
                    q.add(new Tuple(dis+1,nr,nc));
                }
            }
        }
        return -1;
    }
}