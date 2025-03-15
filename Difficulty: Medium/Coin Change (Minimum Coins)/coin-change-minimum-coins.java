//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {

    public int minCoins(int coins[], int sum) {
        // code here
        int[][] dp = new int[coins.length][sum+1];
        Arrays.sort(coins);
        for(int r = 0;r<coins.length;r++){
            int amt = coins[r];
            for(int c = 1;c<sum+1;c++){
                if(amt > c){
                    if(r == 0){
                        dp[r][c] = Integer.MAX_VALUE;
                    }else{
                        dp[r][c] = dp[r-1][c];
                    }
                }else{
                    if(dp[r][c - amt] == Integer.MAX_VALUE){
                        dp[r][c] = Integer.MAX_VALUE;
                    }else{
                        dp[r][c] = dp[r][c - amt] + 1;
                    }
                    if(r > 0){
                        dp[r][c] = Math.min(dp[r][c],dp[r-1][c]);
                    }
                    
                    
                }
            }
        }
        
        return dp[coins.length-1][sum] == Integer.MAX_VALUE ? -1:dp[coins.length-1][sum];
        
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minCoins(arr, k);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends