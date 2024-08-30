class Solution {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<int[]>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++)
        {
            int nodeA=edges[i][0], nodeB=edges[i][1];
            adj[nodeA].add(new int[]{nodeB,i});
            adj[nodeB].add(new int[]{nodeA,i});
        }
        
        int[][] dist=new int[n][2];
        Arrays.fill(dist[source],0);
        for(int i=0;i<n;i++)
        {
            if(i!=source)
            {
                dist[i][0]=dist[i][1]=Integer.MAX_VALUE;
            }
        }
        dijkstra(adj,edges,dist,source,0,0);
        int diff=target-dist[destination][0];
        if(diff<0) return new int[][]{};
        
        dijkstra(adj,edges,dist,source,diff,1);
        if(dist[destination][1]<target) return new int[][]{};
        
        for(int[] edge:edges)
        {
            if(edge[2]==-1) edge[2]=1;
        }
        return edges;
    }
    private void dijkstra(List<int[]>[] adj,int[][] edges,int[][]dist,int src,int diff,int run)
    {
        int n=adj.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src,0});
        dist[src][run]=0;
        while(!pq.isEmpty())
        {
            int[] curr=pq.poll();
            int curNode=curr[0];
            int curDist=curr[1];
            
            if(curDist>dist[curNode][run]) continue;
            for(int[] neighbor:adj[curNode])
            {
                int nextnode=neighbor[0],edgeIn=neighbor[1];
                int wt=edges[edgeIn][2];
                
                if(wt==-1) wt=1;
                
                if(run==1 && edges[edgeIn][2]==-1)
                {
                    int newWt=diff+dist[nextnode][0]-dist[curNode][1];
                    if(newWt>wt)
                    {
                        edges[edgeIn][2]=wt=newWt;
                    }
                }
                if(dist[nextnode][run]>dist[curNode][run]+wt)
                {
                    dist[nextnode][run]=dist[curNode][run]+wt;
                    dist[nextnode][run]=dist[curNode][run]+wt;
                    pq.add(new int[]{nextnode,dist[nextnode][run]});
                }
            }
        }
    }
}



   