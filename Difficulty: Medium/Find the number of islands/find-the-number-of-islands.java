//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.countIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    public int countIslands(char[][] grid) {
        // Code here
        int cnt = 0;
        int row = grid.length , col = grid[0].length;
        for(int i = 0;i<row;i++){
            for(int j = 0 ;j<col;j++){
                if(grid[i][j] == 'L'){
                    cnt++;
                    dfs(i,j,row,col,grid);
                }
            }
        }
        return cnt;
        
    }
    
    void dfs(int r,int c,int row,int col,char[][] grid){
        if(r < 0 || r >= row || c < 0 || c >= col || grid[r][c] != 'L'){
            return;
        }
        
        grid[r][c] = 'W';
        int[][]  adj = {
            {-1,-1},{-1,0},{-1,1},
            {0,-1},{0,1},
            {1,-1},{1,0},{1,1}
        };
        
        for(int i = 0;i<8;i++){
            dfs(r+adj[i][0],c+adj[i][1],row,col,grid);
        }
    }
}