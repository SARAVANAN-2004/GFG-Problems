//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        Set<Integer> set = new HashSet<>();
        int n = 0;
        for(int i:arr){
            set.add(i);
            n = Math.max(n,i);
        }
        int len = 0, cnt = 0;
        for(int i= 0;i<=n;i++){
            if(set.contains(i)){
                cnt++;
            }else{
                len = Math.max(len,cnt);
                cnt = 0;
            }
        }
        return Math.max(len,cnt);
        
        
    }
}