//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public int maxWater(int height[]) {
        // Code Here
        int left = 0 , right = height.length - 1;
        int lmax = height[0] , rmax = height[right];
        int res = Math.min(lmax,rmax) * (right - left);
        while(left < right){
            if(height[left] < height[right]){
                left++;
                lmax = Math.max(lmax,height[left]);
            }else{
                right--;
                rmax = Math.max(rmax,height[right]);
            }
            res = Math.max(Math.min(lmax,rmax) * (right - left),res);

        }
        return res;
    }
}