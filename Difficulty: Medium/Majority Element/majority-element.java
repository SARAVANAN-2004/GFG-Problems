//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().majorityElement(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int majorityElement(int arr[]) {
        // code here
        int ele = arr[0] , cnt  = 1;
        for(int i  = 1;i<arr.length;i++){
            if(ele == arr[i]) cnt++;
            else{
                cnt --;
                if(cnt == 0){
                    ele = arr[i];
                    cnt = 1;
                }
            }
        }
        cnt = 0;
        for(int i:arr){
            if(i == ele){
                cnt++;
            }
        }
        if(cnt >  arr.length/2) return ele;
        return -1;
    }
}