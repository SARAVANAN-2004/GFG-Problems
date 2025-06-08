class Solution {
    
    
    
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int[][] dp = new int[val.length][W+1];
        for(int i[]:dp) Arrays.fill(i,-1);
        return solve(val.length-1,W,val,wt,dp);
        
    }
    
    static int solve(int i,int w,int[] val,int []wt,int [][]dp){
        if(dp[i][w] != -1){
            return dp[i][w];
        }
        if(i == 0){
            if(wt[i] <= w){
                return val[i];
            }else{
                return 0;
            }
        }
        
        int not_take = solve(i-1,w,val,wt,dp);
        
        int take = Integer.MIN_VALUE;
        if(wt[i] <= w){
            take = val[i] + solve(i-1,w-wt[i],val,wt,dp);
        }
        return dp[i][w] = Math.max(take,not_take);
    }
}
