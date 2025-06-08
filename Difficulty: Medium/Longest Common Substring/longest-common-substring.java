// User function Template for Java

class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        // code here
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];
        int maxi = 0;
        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<m+1;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = 0;
                }
                maxi = Math.max(maxi,dp[i][j]);
            }
        }
        return maxi;
    }
}