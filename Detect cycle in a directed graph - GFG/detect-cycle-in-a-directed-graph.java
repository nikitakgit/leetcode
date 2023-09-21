//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
       boolean visited[] =new boolean[V];
        boolean pathVis[] =new boolean[V];
       for(int i=0;i<V;i++)
        if(!visited[i])
           if(dfsCheck(i,adj,visited,pathVis))
           return true;
           
           return false;
    }
    boolean dfsCheck(int v,ArrayList<ArrayList<Integer>> adj,  boolean visited[], boolean pathVis[])
    {
        visited[v]=true;
        pathVis[v]=true;
        for(Integer neg:adj.get(v))
        {
            //when node is not visited
            if(!visited[neg]){
              if(dfsCheck(neg,adj,visited,pathVis))
              return true;}
            //if node has been previously visited but it has to be visited on the same path
            else if(pathVis[neg])
            return true;
        }
        
        //backTrack
         pathVis[v]=false;
         return false;
    }
}