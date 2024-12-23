//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int rows = sc.nextInt();
            int columns = sc.nextInt();

            int matrix[][] = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int target = sc.nextInt();

            Solution x = new Solution();

            if (x.searchRowMatrix(matrix, target))
                System.out.println("true");
            else
                System.out.println("false");
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchRowMatrix(int[][] mat, int x) {
        // code here
        int l = 0,r = mat[0].length-1;
        
        for(int row = 0;row<mat.length;row++){
            if(mat[row][l] <= x && x <= mat[row][r]){
                if(search(mat,row,l,r,x)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean search(int[][] arr,int row,int l,int r,int x){
        while(l<=r){
            int mid = (l+r)/2;
            if(arr[row][mid] == x){
                return true;
            }
            if(arr[row][mid] < x){
                l = mid+1;
            }else{
                r = mid-1;
            }
           
        }
        return false;
    }
}
