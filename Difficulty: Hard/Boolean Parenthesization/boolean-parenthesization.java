//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Solution obj = new Solution();
            System.out.println(obj.countWays(s));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static boolean evaluate(int b1, int b2, char op)
    {
        if (op == '&') {
            return (b1 & b2) == 1;
        }
        else if (op == '|') {
            return (b1 | b2) == 1;
        }
        return (b1 ^ b2) == 1;
    }

    // Function which returns the number of ways
    // s[i:j] evaluates to req.
    static int countRecur(int i, int j, int req, String s,
                          int[][][] memo)
    {

        // Base case:
        if (i == j) {
            return (req == (s.charAt(i) == 'T' ? 1 : 0))
                ? 1
                : 0;
        }

        // If value is memoized
        if (memo[i][j][req] != -1) {
            return memo[i][j][req];
        }

        int ans = 0;
        for (int k = i + 1; k < j; k += 1) {

            // Count Ways in which left substring
            // evaluates to true and false.
            int leftTrue = countRecur(i, k - 1, 1, s, memo);
            int leftFalse
                = countRecur(i, k - 1, 0, s, memo);

            // Count Ways in which right substring
            // evaluates to true and false.
            int rightTrue
                = countRecur(k + 1, j, 1, s, memo);
            int rightFalse
                = countRecur(k + 1, j, 0, s, memo);

            // Check if the combinations result
            // to req.
            if (evaluate(1, 1, s.charAt(k)) == (req == 1)) {
                ans += leftTrue * rightTrue;
            }
            if (evaluate(1, 0, s.charAt(k)) == (req == 1)) {
                ans += leftTrue * rightFalse;
            }
            if (evaluate(0, 1, s.charAt(k)) == (req == 1)) {
                ans += leftFalse * rightTrue;
            }
            if (evaluate(0, 0, s.charAt(k)) == (req == 1)) {
                ans += leftFalse * rightFalse;
            }
        }

        return memo[i][j][req] = ans;
    }

    static int countWays(String s)
    {

        int n = s.length();
        int[][][] memo = new int[n][n][2];
        for (int[][] mat : memo) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }
        return countRecur(0, n - 1, 1, s, memo);
    }
}