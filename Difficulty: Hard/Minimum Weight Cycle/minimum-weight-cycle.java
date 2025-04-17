//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine());
            int E = Integer.parseInt(sc.nextLine());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                edgeList.add(new int[] {u, v, w});
                edgeList.add(new int[] {v, u, w});
            }

            int[][] edges = new int[edgeList.size()][3];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            Solution obj = new Solution();
            int res = obj.findMinCycle(V, edges);

            System.out.println(res);
        }

        sc.close();
    }
}

// } Driver Code Ends


class Solution {
     public int findMinCycle(int V, int[][] edges) {

        int[][] dist = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = (i == j) ? 0 : 100000;
            }
        }
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            dist[u][v] = Math.min(dist[u][v], w);
            dist[v][u] = Math.min(dist[v][u], w);
        }
        
        int minCycle = Integer.MAX_VALUE;
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            
            dist[u][v] = 100000;
            dist[v][u] = 100000;
            
            for (int k = 0; k < V; k++) {
                for (int i = 0; i < V; i++) {
                    for (int j = 0; j < V; j++) {
                        if (dist[i][k] != 100000 && dist[k][j] != 100000) {
                            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        }
                    }
                }
            }
            
            if (dist[v][u] != 100000) {
                minCycle = Math.min(minCycle, w + dist[v][u]);
            }
            
            dist[u][v] = w;
            dist[v][u] = w;
            
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (i != j) dist[i][j] = 100000;
                }
            }

            for (int[] e : edges) {
                dist[e[0]][e[1]] = Math.min(dist[e[0]][e[1]], e[2]);
                dist[e[1]][e[0]] = Math.min(dist[e[1]][e[0]], e[2]);
            }
        }
        
        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }
};