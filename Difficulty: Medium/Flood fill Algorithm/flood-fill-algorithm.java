//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            int[][] image = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S2 = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) image[i][j] = Integer.parseInt(S2[j]);
            }
            int sr = Integer.parseInt(br.readLine().trim());
            int sc = Integer.parseInt(br.readLine().trim());
            int newColor = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    int row,col;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        row = image.length;
        col = image[0].length;
        if(newColor != image[sr][sc]){
            
        
        dfs(image,sr,sc,newColor,image[sr][sc]);
        }
        return image;
    }
    
    void dfs(int[][] img,int r,int c,int color,int original){
        if(r < 0 || r >=row || c < 0 || c>= col || img[r][c] != original){
            return;
        }
        img[r][c] = color;
        dfs(img,r+1,c,color,original);
        dfs(img,r-1,c,color,original);
        dfs(img,r,c+1,color,original);
        dfs(img,r,c-1,color,original);
    }
}