class Solution {
    public int findCircleNum(int[][] isConnected) {
       djs(isConnected.length);
        for(int i=0 ; i<isConnected.length; i++){
            for(int j=0 ; j<isConnected[i].length ;j++){
                if(isConnected[i][j]==1){
                    union(i,j);
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0 ; i<isConnected.length ; i++){
            set.add(find(i));
        }
        return set.size();
    }
    int [] parent = new int [200];
    void djs(int n){
        for(int i=0 ; i<n ;i++){
            parent[i]=i;
        }
    }
    int find(int node){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = find(parent[node]);
    }
    boolean union(int u, int v){
        u = find(u);
        v = find(v);
        if(u!=v){
            parent[v] = u;
            return true;
        }
        return false;
    }
}