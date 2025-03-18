//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution ob = new Solution();

            if (ob.equalPartition(arr))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static boolean equalPartition(int arr[]) {
        // code here
        int sum = 0;
        for(int i:arr){
            sum += i;
        }
        
        if(sum % 2 == 1) return false;
        
        int t = sum/2;
        boolean[][] dp = new boolean[arr.length+1][t+1];
      
        for(int i = 0;i<arr.length+1;i++){
            dp[i][0] = true;
        }
        for(int i = 1;i<arr.length+1;i++){
            for(int j = 1;j<=t;j++){
                dp[i][j] = dp[i-1][j];
                
                if(j >= arr[i-1]){
                    dp[i][j] = dp[i][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }
        
        return dp[arr.length][t];
    }
}