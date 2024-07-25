class Solution {
    public int[] findOrder(int V, int[][] prerequisites) {
        int n=prerequisites.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<n;i++)
        {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        int[] indeg=new int[V];
        for(int i=0;i<V;i++)
        {
            for(int it:adj.get(i))
            {
                indeg[it]++;
            }
        }
        
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++)
        {
            if(indeg[i]==0)
            {
                q.add(i);
            }
        }
        List<Integer> topo=new ArrayList<>();
        while(!q.isEmpty())
        {
            int node=q.poll();
            topo.add(node);
            for(int it:adj.get(node))
            {
                indeg[it]--;
                if(indeg[it]==0)
                {
                    q.add(it);
                }
            }
        }
        int[] ans=new int[V];
        if(topo.size()==V)
        {
            Collections.reverse(topo);
            for(int i=0;i<topo.size();i++)
            {
                ans[i]=topo.get(i);
            }
            return ans;
        }
        return new int[0];
    }
}