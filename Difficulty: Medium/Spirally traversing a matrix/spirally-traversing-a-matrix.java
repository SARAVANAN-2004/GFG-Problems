//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        // code here
        int top = 0,left = 0,bottom = mat.length-1,right = mat[0].length-1;
        int n = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while(left <= right && top <= bottom){
            if(n == 0){
                for(int i = left;i<=right;i++){
                    arr.add(mat[top][i]);
                }
                top++;
            }
            
            else if(n == 1){
                for(int i = top;i<=bottom;i++){
                    arr.add(mat[i][right]);
                }
                right--;
            }
            else if(n == 2){
                for(int i = right;i>=left;i--){
                    arr.add(mat[bottom][i]);
                }
                bottom--;
            }else{
                for(int i = bottom;i>=top;i--){
                    arr.add(mat[i][left]);
                }
                left++;
            }
            // System.out.println(top+" "+bottom+" "+left+" "+right);
            n++;
            n%=4;
            
        }
        return arr;
    }
}
