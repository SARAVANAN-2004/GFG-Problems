//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().matrixMultiplication(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int minMultRec(int[] arr, int i, int j,
                          int[][] memo)
    {

        if (i + 1 == j)
            return 0;

        if (memo[i][j] != -1)
            return memo[i][j];

        int res = Integer.MAX_VALUE;

        for (int k = i + 1; k < j; k++) {
            int curr = minMultRec(arr, i, k, memo)
                       + minMultRec(arr, k, j, memo)
                       + arr[i] * arr[k] * arr[j];

            res = Math.min(curr, res);
        }

        // Store the result in memo table
        memo[i][j] = res;
        return res;
    }

    static int matrixMultiplication(int[] arr)
    {

        int n = arr.length;
        int[][] memo = new int[n][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        return minMultRec(arr, 0, n - 1, memo);
    }
}