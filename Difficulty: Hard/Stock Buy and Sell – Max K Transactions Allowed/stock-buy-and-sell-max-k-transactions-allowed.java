//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String[] input = br.readLine().split(" ");
            int arr[] = new int[input.length];

            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(input[i]);

            // Read the integer k
            int k = Integer.parseInt(br.readLine());

            // Call the solution function
            Solution obj = new Solution();
            System.out.println(obj.maxProfit(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static Integer[][][] dp;
    static int maxProfit(int prices[], int k) {
        // code here
        dp = new Integer[prices.length+1][k+1][2];
        return solve(0,prices,true,k);
    }
    
    static int solve(int i, int[] price,boolean buy,int k){
        if(k <= 0 || i >= price.length) return 0;
        
        if(dp[i][k][buy? 1:0] != null) return dp[i][k][buy?1:0];
        int res = 0, pro = 0;
        if(buy){
            pro = solve(i+1,price,false,k) - price[i];
            res  = Math.max(res,pro);
        }else{
            pro = price[i] + solve(i+1,price,true,k-1);
            res =Math.max(res,pro);
        }
        
        pro = solve(i+1,price,buy,k);
        dp[i][k][buy? 1:0] = Math.max(pro,res);
        return dp[i][k][buy? 1:0];
    }
}