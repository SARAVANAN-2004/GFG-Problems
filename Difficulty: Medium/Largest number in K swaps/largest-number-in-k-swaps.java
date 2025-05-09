//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String str = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findMaximumNum(str, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to find the largest number after k swaps.
    public String findMaximumNum(String s, int k) {
        // code here.
        char[] arr = s.toCharArray();
        int i = 0;
        while(k > 0 && i < arr.length){
            int j = large(i,arr);
            if(j != -1){
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            k--;
            }
            i++;
            
        }
        return String.valueOf(arr);
    }
    int large(int st,char[] arr){
        int j = -1;
        int n = arr[st] - '0';
        for(int i = st+1;i<arr.length;i++){
            if((j == -1 && n < arr[i]-'0') || (j != -1 && n <= arr[i]-'0')){
                j = i;
                n = arr[i]-'0';
            }
        }
        return j;
    }
}