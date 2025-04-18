//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;


class GFG{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0){
            int N = sc.nextInt();
            int Edge[] = new int[N];
            for(int i = 0; i < N; i++)
                Edge[i] = sc.nextInt();
            Solution ob = new Solution();
            long ans = ob.largesSumCycle(N, Edge);
            out.println(ans);            
        
out.println("~");
}
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
   

    public long largesSumCycle(int n, int edge[]){
        boolean[] visited = new boolean[n];
        long maxSum = -1;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Map<Integer, Integer> path = new HashMap<>(); // Node -> step number
                int node = i, step = 0;

                while (node != -1) {
                    if (path.containsKey(node)) {
                        // Found a cycle
                        long sum = 0;
                        for (Map.Entry<Integer, Integer> entry : path.entrySet()) {
                            if (entry.getValue() >= path.get(node)) {
                                sum += entry.getKey();
                            }
                        }
                        maxSum = Math.max(maxSum, sum);
                        break;
                    }

                    if (visited[node]) break;

                    visited[node] = true;
                    path.put(node, step++);
                    node = edge[node];
                }
            }
        }

        return maxSum;
  
    }
}