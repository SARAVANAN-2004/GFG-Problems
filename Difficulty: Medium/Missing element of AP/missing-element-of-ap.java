//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        Solution solution = new Solution();
        while (t-- > 0) {
            String input = reader.readLine().trim();
            String[] parts = input.split("\\s+");
            int[] arr = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();

            System.out.println(solution.findMissing(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findMissing(int[] arr) {
        // code here
        int[] cnt = new int[2];
        int n = arr.length;
        int[] dp = new int[n-1];
        for(int i = 1;i<n;i++){
            dp[i-1] = arr[i] - arr[i-1];
        }
        
        
        int cur = dp[0];
        int diff = -1;
         int idx = -1;
        for(int i = 0;i<n-1;i++){
            if(dp[i] == cur){
                cnt[0]++;
            }else{
                idx = i;
                diff = dp[i];
                cnt[1]++;
            }
        }
        if(n-1 == 1 || idx == -1){
            return arr[n-1] + dp[0];
        }
        if(n-1 == 2){
            if(cur < diff){
                return arr[1] + cur;
            }else{
                return arr[0] + diff;
            }
        }else{
            if(cnt[0] == 1) return arr[0] + diff;
            else return arr[idx] + cur;
        }
        
    }
}
