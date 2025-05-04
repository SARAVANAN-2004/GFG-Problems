//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findSubString(String str) {
    int n = str.length();
    
    // Step 1: Count distinct characters in the string
    int totalDistinct = 0;
    int[] freq = new int[26];
    for (char c : str.toCharArray()) {
        if (freq[c - 'a'] == 0) totalDistinct++;
        freq[c - 'a']++;
    }

    // Reset frequency for window calculation
    int[] windowFreq = new int[26];
    int count = 0, minLen = n;
    int left = 0;

    for (int right = 0; right < n; right++) {
        char ch = str.charAt(right);
        if (windowFreq[ch - 'a'] == 0) count++;
        windowFreq[ch - 'a']++;

        while (count == totalDistinct) {
            minLen = Math.min(minLen, right - left + 1);

            // Try to shrink window
            char leftChar = str.charAt(left);
            windowFreq[leftChar - 'a']--;
            if (windowFreq[leftChar - 'a'] == 0) count--;
            left++;
        }
    }

    return minLen;
}
}