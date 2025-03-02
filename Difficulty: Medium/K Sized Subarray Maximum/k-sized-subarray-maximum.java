//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
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
            ArrayList<Integer> res = new Solution().maxOfSubarrays(arr, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<k;i++){
            int x = arr[i];
            if(map.containsKey(x)){
                map.put(x,map.get(x)+1);
            }else{
                pq.add(x);
                map.put(x,1);
            }
        }
        res.add(pq.peek());
        for(int i = k;i<arr.length;i++){
            map.put(arr[i-k],map.get(arr[i-k])-1);
            if(map.get(arr[i-k]) == 0){
                map.remove(arr[i-k]);
                pq.remove(arr[i-k]);
            }
            
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            if(map.get(arr[i]) == 1){
                pq.add(arr[i]);
            }
            res.add(pq.peek());
            // System.out.println(res);
        }
        
        return res;
    }
}