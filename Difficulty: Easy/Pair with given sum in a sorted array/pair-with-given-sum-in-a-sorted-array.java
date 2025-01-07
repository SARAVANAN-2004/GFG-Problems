//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
       int n = arr.length;
       int l = 0, r = n-1;
       int res = 0;
       while(l<r){
           if(arr[l] + arr[r] < target){
               l++;
           }
           
           else if (arr[l] + arr[r] > target){
               r--;
           }
           
           else{
               int c1 = 0 , c2 = 0;
               int ele1 = arr[l],ele2 = arr[r];
               while(l<=r && arr[l] == ele1){
                   l++;
                   c1++;
               }
               
               while(l<=r && arr[r] == ele2){
                  r--; 
                  c2++;
               }
               
               if(ele1 == ele2){
                   res += (c1 * (c1-1))/2;
               }else{
                   res += (c1*c2);
               }
           }
       }
       return res;
       
    }
}


//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends