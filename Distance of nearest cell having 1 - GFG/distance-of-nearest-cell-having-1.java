//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

class Pair{
        int first;
        int second;
        int third;
        Pair(int first,int second,int third)
        {
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
class Solution
{
    
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int visited[][]=new int[n][m];
        int dis[][]=new int[n][m];
        
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    q.add(new Pair(i,j,0));
                    visited[i][j]=1;
                }else{
                    visited[i][j]=0;
                }
                
            }
        }
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        
        while(!q.isEmpty())
        {
            int row=q.peek().first;
            int col=q.peek().second;
            int steps=q.peek().third;
            
            q.remove();
            dis[row][col]=steps;
            
            for(int i=0;i<4;i++)
            {
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0)
                {
                    visited[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol,steps+1));
                }
            }
        }
        return dis;
    }
}