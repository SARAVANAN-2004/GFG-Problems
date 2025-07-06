class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // code here
        Arrays.sort(a);
        Arrays.sort(b);
    
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> pq  = new PriorityQueue<>((x,y)->y[2] - x[2]);
        int n = a.length;
        int i = n-1, j = n-1;
        pq.add(new int[]{i,j,a[i]+b[j]});
        
        // boolean[][] vis  = new boolean[n][n];
        // vis[i][j] = true;
        Set<String> vis = new HashSet<>();
        vis.add(i+"#"+j);
        while(k-- > 0){
            int[] cur = pq.poll();
            ans.add(cur[2]);
            i = cur[0] ;
            j = cur[1];
            if(i -1 >=0 && !vis.contains((i-1)+"#"+j) ){
                pq.add(new int[]{i-1,j,a[i-1]+b[j]});
                // System.out.println(a[i-1]+b[j]);
                // vis[i-1][j] = true;
                vis.add((i-1)+"#"+j);
            }
            if(j -1 >=0 && !vis.contains(i+"#"+(j-1)) ){
                pq.add(new int[]{i,j-1,a[i]+b[j-1]});
                // System.out.println(a[i]+b[j-1]);
                // vis[i][j-1] =true;
                vis.add(i+"#"+(j-1));
            }
            
            
        }
        return ans;
    }
}