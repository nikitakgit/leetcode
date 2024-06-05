class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int m = edges.length; 
        int[][] dist = new int[n][n]; 
        
        for(int[] row : dist){
            Arrays.fill(row, Integer.MAX_VALUE); 
        }
        
        for(int i = 0; i<m; i++){
            int u = edges[i][0]; 
            int v = edges[i][1]; 
            int wt = edges[i][2]; 
            dist[u][v] = wt; 
            dist[v][u] = wt; 
        }
        for(int i = 0; i<n; i++){
            dist[i][i] = 0; 
        }
        for(int via = 0; via < n; via++){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(dist[i][via] == Integer.MAX_VALUE || dist[via][j] == Integer.MAX_VALUE){
                        continue; 
                    }
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]); 
                }
            }
        }
        
        int cntCity = n; 
        int cityNo = -1; 
        
        for(int city=0; city<n; city++){
            int cnt=0;
            for(int adjcity = 0; adjcity<n; adjcity++){
                if(dist[city][adjcity] <= distanceThreshold){
                    cnt++;
                }
            }
            if(cnt<= cntCity){
                cntCity = cnt; 
                cityNo = city; 
            }
        }
        return cityNo; 
    }
}