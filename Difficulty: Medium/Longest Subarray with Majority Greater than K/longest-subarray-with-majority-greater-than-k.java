//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    static int longestSubarray(int[] arr, int k) {
        // Code Here
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefix[] = new int[n];
        int ans = 0;
        
        for(int i=0; i<n ; i++) {
            int prev = i>0 ? prefix[i-1] : 0;
            
            prefix[i] += prev;
            prefix[i] += arr[i] > k ? 1 : -1;
            
            int curSum = prefix[i];
            if(curSum>0) ans = Math.max(ans, i+1);
            int required = curSum-1;
            if(map.containsKey(required)) {
                int startInd = map.get(required);
                ans = Math.max(ans, i-startInd);
            }
            
            if(!map.containsKey(prefix[i])) {
                map.put(prefix[i], i);
            }
            
        }
        
        
        return ans;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            int n = tokens.length;
            int[] arr = new int[n];

            int i = 0;
            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr[i] = Integer.parseInt(token);
                i++;
            }

            int k = Integer.parseInt(br.readLine().trim());
            System.out.println(new Solution().longestSubarray(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends