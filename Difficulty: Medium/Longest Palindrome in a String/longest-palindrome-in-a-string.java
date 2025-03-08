//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static String longestPalindrome(String s) {
        // code here
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        if(n == 1) return s;
        for(int i = 1;i<=n;i++){
            dp[i][i] = 1;
        }
        int max = 1;
        int[] idx = new int[]{0,0};
        for(int i = 0;i<n-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 1;
                dp[i+1][i] = 1;
                
                if(max == 1){
                    idx[0] = i;
                    idx[1] = i+1;
                    max = 2;

                }
            }
        }
        
        for(int r = n-3;r>=0;r--){
            for(int c = r+2;c<n;c++){
                if(s.charAt(r) == s.charAt(c)){
                    if(dp[r+1][c-1] == 1){
                        dp[r][c] = 1;
                        if(dp[r][c] == 1 && max <= c-r+1){
                            max = c-r+1;
                            idx[0] = r;
                            idx[1] = c;
                            
                        }
                    }
                }
            }
        }
        // for(int[] i :dp){
        //     System.out.println(Arrays.toString(i));
        // }
        return s.substring(idx[0],idx[1]+1);
        
    }
}