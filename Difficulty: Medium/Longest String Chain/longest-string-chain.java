//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] words = sc.nextLine().trim().split(" ");
            Solution obj = new Solution();
            int res = obj.longestStringChain(words);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int longestStringChain(String words[]) {
        
        Arrays.sort(words, Comparator.comparingInt(String::length));

        Map<String, Integer> cnt = new HashMap<>();
        int maxi = 1; 
        for (String s : words) {
            cnt.put(s, 1);

            for (int i = 0; i < s.length(); i++) {
                
                String prev = s.substring(0, i) + s.substring(i + 1);

                if (cnt.containsKey(prev)) {
                    cnt.put(s, Math.max(cnt.get(s), cnt.get(prev) + 1));
                }
            }

            maxi = Math.max(maxi, cnt.get(s));
        }

        return maxi;
    }
}



