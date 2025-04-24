//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSingle(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static boolean checkbit(int x, int i){
         return ((x >> i) & 1) == 1;
    }
    int ans = 0;
    public int getSingle(int[] arr) {
        // code here
        for(int i = 0; i <= 31; i++){
            int count = 0;
            for(int j = 0; j < arr.length; j++){
                if(checkbit(arr[j], i)){
                    count  = count +1;
                }
            }
            if(count % 3 == 1){
                ans = ans + (1 << i);
            }
        }
        return ans;
    }
}