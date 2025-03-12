//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            int capacity = Integer.parseInt(br.readLine());
            String[] valInput = br.readLine().split(" ");
            String[] wtInput = br.readLine().split(" ");

            int[] val = new int[valInput.length];
            int[] wt = new int[wtInput.length];

            for (int i = 0; i < valInput.length; i++) {
                val[i] = Integer.parseInt(valInput[i]);
            }

            for (int i = 0; i < wtInput.length; i++) {
                wt[i] = Integer.parseInt(wtInput[i]);
            }

            System.out.println(Solution.knapsack(capacity, val, wt));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    static int knapsack(int capacity, int val[], int wt[]) {
        // code here
        int n = val.length;
        int dp[][] = new int[n][capacity+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<capacity+1;j++){
                dp[i][j] = -1;
            }
        }
        return recur(capacity, val, wt, n-1,dp);
    }
    static int recur(int capacity, int val[], int wt[], int index, int dp[][]){
        // base case
        if(capacity == 0) {
            dp[index][capacity] = 0;
            return 0;
        }
        if(index==0){
            if(wt[index]<=capacity){
                dp[index][capacity] = val[index];
                return val[index];
            }else{
                dp[index][capacity] = 0;
                return 0;
            }
        }
        if(dp[index][capacity]!=-1){
            return dp[index][capacity];
        }
        int pick = 0;
        if(wt[index] <= capacity){
            pick = val[index] + recur(capacity - wt[index], val, wt, index-1, dp);
        }

        int noPick = 0 + recur(capacity, val, wt, index-1,dp);
        dp[index][capacity] = Math.max(pick, noPick);
        return dp[index][capacity];
    }
}
