//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine())
                               .trim()
                               .split(" "); // Read the input for the current test case
            int arr[] = new int[str.length];
            // Convert input string into an integer array
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            // Call the solution method and print the result
            System.out.println(new Solution().lis(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int[] memo ;
    static int lis(int arr[]) {
        // code here
        int n = arr.length;
        memo = new int[n];
        Arrays.fill(memo,-1);
        
        int maxi = 0;
        for(int i = 0;i<n;i++){
            maxi = Math.max(maxi,solve(arr,i));
        }
        
        return maxi;
    }
    
    static int solve(int[] arr,int idx){
        if(idx == 0) return 1;
        
        if(memo[idx] != -1) return memo[idx];
        
        int maxi = 1;
        for(int i = 0;i<idx;i++){
            if(arr[i] < arr[idx])
             maxi = Math.max(maxi,solve(arr,i)+1);
        }
        
        memo[idx] = maxi;
        return maxi;
    }
}