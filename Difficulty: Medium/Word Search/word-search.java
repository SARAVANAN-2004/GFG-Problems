//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] mat = new char[n][m];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }

            String word = sc.next();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(mat, word);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    static int row , col;
    static public boolean isWordExist(char[][] mat, String word) {
        // Code here
        row = mat.length;
        col = mat[0].length;
         for(int r = 0;r<row;r++){
             for(int c = 0;c<col;c++){
                 if(mat[r][c] == word.charAt(0)){
                 if(solve(mat,word,0,r,c)){
                     return true;
                 }
                 }
             }
         }
         return false;
    }
    
    static boolean solve(char[][] mat,String word,int idx,int r,int c){
        
        if(idx == word.length()) return true;
        if(r < 0 || r >= row || c < 0 || c >= col || mat[r][c] != word.charAt(idx)){
            return false;
        }
        
        
        char backup = mat[r][c];
        mat[r][c] = '*';
        if(solve(mat,word,idx+1,r+1,c) || solve(mat,word,idx+1,r-1,c) ||
        solve(mat,word,idx+1,r,c+1) || solve(mat,word,idx+1,r,c-1)){
            return true;
        }
        mat[r][c] = backup;
        return false;
    }
}