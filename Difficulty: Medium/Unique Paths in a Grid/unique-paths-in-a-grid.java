class Solution {
    public int uniquePaths(int[][] grid) {
        // code here
        int n = grid.length, m = grid[0].length;
        int[][] dp =  new int[n][m];
        if(grid[0][0]  == 1 || grid[n-1][m-1] == 1) return 0;
        dp[0][0] = 1;
        for(int r = 1;r<n;r++){
            if(grid[r][0] == 0)dp[r][0] = dp[r-1][0];
        }
        for(int c = 1;c<m;c++){
            if(grid[0][c] == 0) dp[0][c] = dp[0][c-1]; 
        }
        // for(int[] r:dp) System.out.println(Arrays.toString(r));
        for(int r = 1;r<n;r++){
            for(int c = 1;c<m;c++){
                if(grid[r][c] == 0){
                    dp[r][c] = dp[r-1][c] + dp[r][c-1];
                }
            }
        }
        
        return dp[n-1][m-1];
    }
};