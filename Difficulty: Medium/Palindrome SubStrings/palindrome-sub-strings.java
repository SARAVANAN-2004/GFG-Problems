//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();

            Solution obj = new Solution();

            System.out.println(obj.countPS(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    public int countPS(String s) {
        // code here
        int n = s.length();
        boolean[][] dp = new boolean[n+1][n+1];
        for(int i = 1;i<=n;i++){
            dp[i][i] = true;
        }
        
        int cnt = 0;
        for(int i = 0;i<n-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                dp[i+1][i] = true;
                cnt++;
            }
        }
        
        for(int r  = n-3;r>= 0;r--){
            for(int c = r+2;c<n;c++){
                if(s.charAt(r) == s.charAt(c)){
                    dp[r][c] = dp[r+1][c-1];
                    if(dp[r][c]){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}