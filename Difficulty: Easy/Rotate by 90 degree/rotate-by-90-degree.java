//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.rotateby90(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int mat[][]) {
        // code here
        trans(mat);
        
        int l = 0,r = mat.length-1;
        while(l<r){
            reverse(mat,l,r);
            l++;
            r--;
        }
    }
    
    public static void trans(int[][] mat){
        int n = mat.length;
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                int t = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t;
            }
        }
    }
    static void reverse(int[][] mat,int l,int r){
        int n = mat.length;
        for(int i = 0;i<n;i++){
            int t = mat[l][i];
            mat[l][i] =  mat[r][i];
            mat[r][i] = t;
        }
    }
}