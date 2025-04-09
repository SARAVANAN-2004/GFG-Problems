//{ Driver Code Starts
import java.util.*;

public class Main {
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
            ArrayList<Integer> ans = obj.articulationPoints(V, edges);
            Collections.sort(ans);
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static ArrayList<ArrayList<Integer>> constructAdj(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }

    // Helper function to perform DFS and find articulation points
    // using Tarjan's algorithm.
     static void findPoints(ArrayList<ArrayList<Integer>> adj, int u, int[] visited,
                                  int[] disc, int[] low, 
                                  int[] time, int parent, int[] isAP) {
                                      
        // Mark vertex u as visited and assign discovery
        // time and low value
        visited[u] = 1;
        disc[u] = low[u] = ++time[0];
        int children = 0; 

        // Process all adjacent vertices of u
        for (int v : adj.get(u)) {
            
            // If v is not visited, then recursively visit it
            if (visited[v] == 0) {
                children++;
                findPoints(adj, v, visited, disc, low, time, u, isAP);

                // Check if the subtree rooted at v has a 
                // connection to one of the ancestors of u
                low[u] = Math.min(low[u], low[v]);

                // If u is not a root and low[v] is greater 
                // than or equal to disc[u],
                // then u is an articulation point
                if (parent != -1 && low[v] >= disc[u]) {
                    isAP[u] = 1;
                }
            } 
            
            // Update low value of u for back edge
            else if (v != parent) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        // If u is root of DFS tree and has more than 
        // one child, it is an articulation point
        if (parent == -1 && children > 1) {
            isAP[u] = 1;
        }
    }

    // Main function to find articulation points in the graph
     static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = constructAdj(V, edges);
        int[] disc = new int[V], low = new int[V],
        visited = new int[V], isAP = new int[V];
        int[] time = {0}; 

        // Run DFS from each vertex if not
        // already visited (to handle disconnected graphs)
        for (int u = 0; u < V; u++) {
            if (visited[u] == 0) {
                findPoints(adj, u, visited, disc, low, time, -1, isAP);
            }
        }

        // Collect all vertices that are articulation points
        ArrayList<Integer> result = new ArrayList<>();
        for (int u = 0; u < V; u++) {
            if (isAP[u] == 1) {
                result.add(u);
            }
        }

        // If no articulation points are found, return list containing -1
        if (result.isEmpty()) result.add(-1);
        return result;
    }
}