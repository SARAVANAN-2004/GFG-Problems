//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    boolean[] vis;
    public boolean isBridge(int V, int[][] edges, int u, int v) {
        // code here
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i[]:edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        int cnt1 = solve(V,-1,-1);
        int cnt2 = solve(V,u,v);
        // System.out.println(cnt1+" "+cnt2);
        return cnt1 != cnt2;
    }
    public int solve(int v,int c,int d){
        vis = new boolean[v];
        int cnt = 0;
        
        for(int i = 0;i<v;i++){
            if(!vis[i]){
               cnt++;
               dfs(i,c,d);
            }
        }
        return cnt;
    }
    public void dfs(int cur,int c,int d){
        if(vis[cur]) return;
        
        vis[cur] = true;
        for(int i:adj.get(cur)){
            if((cur == c && i == d )||(cur == d && i == c) ){
                continue;
            }else if(!vis[i]){
                dfs(i,c,d);
            }
        }
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            // V and E on separate lines
            int V = Integer.parseInt(sc.nextLine().trim());
            int E = Integer.parseInt(sc.nextLine().trim());

            // Using a 2D array to store edges.
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                // Use split("\\s+") to handle one or more whitespace characters
                String[] parts = sc.nextLine().trim().split("\\s+");
                edges[i][0] = Integer.parseInt(parts[0]);
                edges[i][1] = Integer.parseInt(parts[1]);
            }

            // c and d on separate lines
            int c = Integer.parseInt(sc.nextLine().trim());
            int d = Integer.parseInt(sc.nextLine().trim());

            Solution obj = new Solution();
            boolean result = obj.isBridge(V, edges, c, d);
            System.out.println(result ? "true" : "false");
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends