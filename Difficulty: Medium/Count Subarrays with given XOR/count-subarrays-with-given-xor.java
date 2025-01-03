//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        int prefix = 0,res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            prefix ^= arr[i];
            if(prefix == k) res++;
            
            if(map.containsKey(prefix^k)){
                res += map.get(prefix^k);
            }
            
            map.put(prefix,map.getOrDefault(prefix,0)+1);
        }
        
        return res;
    }
}