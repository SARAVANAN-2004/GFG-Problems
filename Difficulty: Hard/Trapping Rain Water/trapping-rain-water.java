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


class Solution {
    public int maxWater(int arr[]) {
        // code here
        int l = 0, r = arr.length-1;
        int lmax = arr[0], rmax = arr[r];
        int water = 0;
        while(l<r){
            if(arr[l] <= arr[r]){
                l++;
                lmax = Math.max(lmax,arr[l]);
                water  += Math.max(lmax - arr[l],0);
            }else{
                r--;
                rmax = Math.max(rmax,arr[r]);
                water += Math.max(rmax - arr[r],0);
                
            }
        }
        return water;
    }
}
