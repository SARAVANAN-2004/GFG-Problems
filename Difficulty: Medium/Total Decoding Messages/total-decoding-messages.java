//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String digits = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countWays(digits);
            out.println(ans);

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    Integer[] dp;
    public int countWays(String digits) {
        // code here
        dp = new Integer[digits.length()+1];
        return decodeHelper(digits,0);
    }
    
    public int decodeHelper(String digits, int index)
    {

        int n = digits.length();

        if (index >= n) {
            return 1;
        }

        if(dp[index] != null) return dp[index];
        int ways = 0;


        if (digits.charAt(index) != '0') {
            ways = decodeHelper(digits, index + 1);
        }

        if ((index + 1 < n)
            && ((digits.charAt(index) == '1'
                 && digits.charAt(index + 1) <= '9')
                || (digits.charAt(index) == '2'
                    && digits.charAt(index + 1) <= '6'))) {

            ways += decodeHelper(digits, index + 2);
        }

        return dp[index] = ways;
    }
}