//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = 9;
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.solveSudoku(matrix);
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
    // Function to find a solved Sudoku.
    static void solveSudoku(int[][] mat) {
        // code here
        
       solve(mat);
    }
    
    static boolean solve(int[][] mat){
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(mat[i][j] == 0){
                    for(int d = 1;d<10;d++){
                        if(isvalid(mat,i,j,d)){
                            mat[i][j] = d;
                            if(solve(mat)){
                                return true;
                            }
                            mat[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
   static boolean isvalid(int[][] mat,int r,int c,int d){
        for(int i = 0;i<9;i++){
            if(mat[r][i] == d || mat[i][c] == d ){
                return false;
            }
            if(mat[3*(r/3)+i%3][3*(c/3)+i/3] == d){
                return false;
            }
        }
        return true;
    }
}