//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int orangesRotting(int[][] grid) {
        // Code here
          int fresh = 0;
        int min  = 0;
        Queue<int[]> queue = new LinkedList<>();
        int row = grid.length , col = grid[0].length;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                else if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        int[][] adj = new int[][]{
            {-1,0},
            {1,0},
            {0,1},
            {0,-1}
        };
        while(!queue.isEmpty() && fresh != 0){
            int size = queue.size();
            // System.out.println(size);
            for(int i = 0;i<size;i++){
                 int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];
                for(int j = 0;j<4;j++){
                    int curR = r+adj[j][0];
                    int curC = c+adj[j][1];
                    if(valid(curR,curC,row,col,grid)){
                        grid[curR][curC] = 2;
                        fresh--;
                        queue.add(new int[]{curR,curC});
                    }
                }

            }
            min++;
        }

        return fresh == 0 ? min : -1;
    }

    boolean valid(int r,int c,int row,int col,int[][] grid){
        return r >= 0 && r<row && c >= 0 && c<col && grid[r][c] == 1;
    }



    
}