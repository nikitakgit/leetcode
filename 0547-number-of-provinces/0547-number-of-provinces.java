//using disjoint set
class Solution {
    public int findCircleNum(int[][] isConnected) {
       ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<isConnected.length;i++)
        {
            adj.add(new ArrayList<>());
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
        
        int[] vis=new int[adj.size()];
        int cnt=0;
        for(int i=0;i<adj.size();i++)
        {
            if(vis[i]==0)
            {
                cnt++;
                dfs(i,vis,adj);
            }
        }
        return cnt;
    }
    public void dfs(int node,int[] vis,ArrayList<ArrayList<Integer>> adj)
    {
        vis[node]=1;
        for(int i:adj.get(node))
        {
            if(vis[i]==0)
            {
                dfs(i,vis,adj);
            }
        }
    }
}