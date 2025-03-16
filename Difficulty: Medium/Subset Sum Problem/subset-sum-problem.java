//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

 
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here

        return solve(0,arr,sum,0);
    }
    
    static boolean solve(int i,int[] arr,int sum,int cur){
        if(cur == sum) return true;
        
        if(cur > sum || i >= arr.length) return false;
        
        
        
        
        return solve(i+1,arr,sum,cur+arr[i]) || solve(i+1,arr,sum,cur);
    }
    
    
}