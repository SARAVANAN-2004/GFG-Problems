//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, edges);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    boolean[] canvis;
    boolean[] visiting;
    List<List<Integer>> adj;
    
    public boolean isCycle(int v, int[][] edges) {
        // Code here
        canvis = new boolean[v];
        visiting = new boolean[v];
        
        adj = new ArrayList<>();
        for(int i = 0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i[]:edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        
        for (int u = 0; u < v; u++) {
            if (!canvis[u]) {
                if (dfs(u, -1))
                    return true;
            }
        }
        return false;
    }
    
    boolean dfs(int cur,int parent){
    canvis[cur] = true;
    
    for(int neighbor : adj.get(cur)){
        if(!canvis[neighbor]){
            if(dfs(neighbor, cur)) return true;
        } else if(neighbor != parent){
            return true; // Found a back edge (cycle)
        }
    }
    
    return false; // No cycle in this path
}

}