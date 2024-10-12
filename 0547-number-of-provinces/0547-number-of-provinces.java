//using disjoint set
class Solution {
    public int findCircleNum(int[][] isConnected) {
       ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<isConnected.length;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<isConnected.length;i++)
        {
            for(int j=0;j<isConnected.length;j++)
            {
                if(isConnected[i][j]==1 && i!=j)
                {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        boolean[] vis=new boolean[adj.size()];
        int cnt=0;
        for(int i=0;i<adj.size();i++)
        {
            if(vis[i]==false)
            {
                cnt++;
                dfs(i,adj,vis);
            }
        }
        return cnt;
    }
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visited)
    {
        
        visited[node]=true;
        for(int i:adj.get(node))
        {
            if(visited[i]==false)
            {
                dfs(i,adj,visited);
            }
        }
    }
}