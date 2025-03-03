//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends


class Solution {

    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        int n = arr.length;
        int begining = 0, maxLen = 0;
        TreeMap<Integer, Integer> window = new TreeMap<>();
        int start = 0;
        for(int end = 0; end < n; end++){
            window.put(arr[end], window.getOrDefault(arr[end], 0) + 1);
            int mini = window.firstKey();
            int maxi = window.lastKey();
            
            if(maxi - mini <= x){
                if(maxLen < end - start + 1){
                    maxLen = end - start + 1;
                    begining = start;
                }
            }else{
                while(start < end){
                    window.put(arr[start], window.getOrDefault(arr[start], 0) - 1);
                    if(window.get(arr[start]) == 0) window.remove(arr[start]);
                    start++;
                    mini = window.firstKey();
                    maxi = window.lastKey();
                    if(maxi - mini <= x) break;
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = begining; i < begining + maxLen; i++){
            res.add(arr[i]);
        }
        return res;
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.longestSubarray(arr, k);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends