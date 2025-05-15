//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();

            Solution ob = new Solution();
            int result = ob.countSubstring(s);

            System.out.println(result);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countSubstring(String s) {
        // code here
        float [] ar = new float[26];
        for(char ch:s.toCharArray()){
            ar[ch-'a']++;
        }
        float sum = 0;
        for(int i = 0;i<26;i++)
        {
            if(ar[i]!=0)
            {
                // System.out.println((float)(ar[i]+1)/2);
                sum+=(float)(ar[i]*((ar[i]+1)/2));
            }
        }
        return (int)sum;
    }
}