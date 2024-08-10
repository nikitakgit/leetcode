class Solution {

    // Function to check if the given graph is bipartite
    public boolean isBipartite(int[][] graph) {
        int m=graph.length;
        
        
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            adj.add(new ArrayList<>());
            
        }
        
        // Convert adjacency matrix to adjacency list
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }

        // Initialize color array with -1 (uncolored)
        int[] color = new int[m];
        Arrays.fill(color, -1);

        // Check each component of the graph
        for (int i = 0; i < m; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, adj)) {
                    return false;
                }
            }
        }

        return true;
        
    }
    
    public boolean dfs(int node,int col,int[] color,ArrayList<ArrayList<Integer>> adj)
    {
        color[node]=col;
        for(int it:adj.get(node))
        {
            if(color[it]==-1)
            {
                if(dfs(it,1-col,color,adj)==false) return false;
               
            }else if(color[it]==col)
            {
                return false;
            }
        }
        return true;
    }
}