//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());

            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                adj.get(edges[i][0]).add(edges[i][1]);
            }

            ArrayList<Integer> res = new Solution().topoSort(V, edges);

            if (check(adj, V, res) == true)
                System.out.println("true");
            else
                System.out.println("false");
            System.out.println("~");
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> adj, int V,
                         ArrayList<Integer> res) {

        if (V != res.size()) return false;

        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res.get(i)] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> topoSort(int v, int[][] edges) {
        // code here
        int[] map = new int[v+1];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i[]:edges){
            map[i[1]]++;
            adj.get(i[0]).add(i[1]);
        }
        
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0;i<v;i++){
            if(map[i] == 0){
                que.add(i);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        while(!que.isEmpty()){
            int cur = que.poll();
            res.add(cur);
            for(int a:adj.get(cur)){
                map[a]--;
                if(map[a] == 0){
                    que.add(a);
                }
            }
        }
        return res;
        
    }
}