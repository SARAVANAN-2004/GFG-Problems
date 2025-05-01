//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Integer> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);

            System.out.println("~");
        }
    }

    public static void printAns(ArrayList<Integer> ans) {
        for (Integer x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Integer> ans;
    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        // code here
        ans = new ArrayList<>();
        if(n <= 2){
            for(int i = 0;i<n;i++) ans.add(1);
            return ans;
        }
        
        int[][] arr = new int[n][n];
        for(int r = 0;r<n;r++){
            for(int c = 0;c<r+1;c++){
                if(c == 0 || c == r){
                    arr[r][c] = 1;
                }else{
                    arr[r][c] = arr[r-1][c-1]+arr[r-1][c];
                }
            }
            if(r == n-1){
                for(int i:arr[r]){
                    ans.add(i);
                }
            }
        }
        
        return ans;
    }
}