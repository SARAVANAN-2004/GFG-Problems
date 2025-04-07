//{ Driver Code Starts
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
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    boolean[] vis;
    List<List<Integer>> adj;
    public boolean isCyclic(int v, int[][] edges) {
        // code here
        adj = new ArrayList<>();
        for(int i = 0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i[]:edges){
            adj.get(i[0]).add(i[1]);
        }
        vis = new boolean[v];
        for(int i = 0;i<v;i++){
            if(!vis[i] && dfs(i)){
                return true;
            }
        }
        return false;
        
    }
    boolean dfs(int cur){
        if(vis[cur]) return true;
        
        vis[cur] = true;
        for(int i :adj.get(cur)){
            if(dfs(i)){
                return true;
            }
        }
        vis[cur] = false;
        return false;
    }
}