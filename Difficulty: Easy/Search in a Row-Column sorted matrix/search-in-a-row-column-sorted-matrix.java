//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }

            int x = sc.nextInt();

            if (new Solution().matSearch(mat, x))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static boolean matSearch(int mat[][], int x) {
        // your code here
        int n = mat.length,m = mat[0].length;
        int l = 0,r = mat.length -1;
        for(int i = 0;i<m;i++){
            if(x >= mat[l][i] && x <= mat[r][i]){
                if(valid(mat,i,n,x)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static boolean valid(int[][] mat,int c,int row,int x){
        for(int i = 0;i<row;i++){
            if(mat[i][c] == x){
                return true;
            }
        }
        return false;
    }
}