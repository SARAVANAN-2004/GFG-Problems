//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            String line = sc.nextLine();
            String[] dictionary = line.split(" ");

            Solution obj = new Solution();
            if (obj.wordBreak(s, dictionary)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    public boolean wordBreak(String s, String[] dictionary) {
        // code here
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        // Traverse through the given string
        for (int i = 1; i <= n; i++) {
            // Traverse through the dictionary words
            for (String w : dictionary) {
                // Check if the current word is present and
                // the prefix before the word is also
                // breakable
                int start = i - w.length();
                if (start >= 0 && dp[start]
                    && s.substring(start,
                                   start + w.length())
                           .equals(w)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    
}