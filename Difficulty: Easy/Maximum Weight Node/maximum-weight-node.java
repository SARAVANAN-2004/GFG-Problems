//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String temp[] = sc.nextLine().trim().split(" ");
            int n = temp.length;
            int exits[] = new int[n];
            for (int i = 0; i < n; i++) exits[i] = Integer.parseInt(temp[i]);
            Solution sln = new Solution();
            System.out.println(sln.maxWeightCell(exits));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxWeightCell(int[] exits) {
        int[] entry = new int[exits.length];
        for(int i = 0;i<exits.length ;i++){
            if(exits[i] != -1){
                entry[exits[i]] += i;
            }
        }
        // System.out.println(Arrays.toString(entry));
        int max  = entry[0], idx = 0;
        for(int i = 0;i<exits.length;i++){
            if(max <= entry[i]){
                idx = i;
                max = entry[i];
            }
        }
        return idx;
    }
}