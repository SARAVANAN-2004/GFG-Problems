class Solution {
    List<List<Integer>> adj;
    int[] vis;
    public int countPaths(int[][] edges, int V, int src, int dest) {
        // Code here
        adj = new ArrayList<>();
        vis = new int[V];
        Arrays.fill(vis,-1);
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
        }
        
        return find(src,dest);
    }
    int find(int src,int dest){
        if(src == dest){
            return 1;
        }
        if(vis[src] != -1) return vis[src];
        int cnt = 0;
        for(int i:adj.get(src)){
            cnt += find(i,dest);
        }
        vis[src] = cnt;
        return cnt;
    }
}