class Solution {
    // Map<String,Integer> map  = new HashMap<>();
    
    int[][][] memo;
    int lcsOf3(String s1, String s2, String s3) {
        // code here
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        memo = new int[n1][n2][n3];
        for(int i[][]:memo){
            for(int j[]:i){
                Arrays.fill(j,-1);
            }
        }
        return find(s1.toCharArray(),s2.toCharArray(),s3.toCharArray(),s1.length()-1,s2.length()-1,s3.length()-1);
    }
    
    int find(char[] s1,char[] s2,char[] s3,int n1,int n2,int n3){
        
        if(n1 == -1 || n2 == -1 || n3 == -1) return 0;
        
        if(memo[n1][n2][n3] != -1) return memo[n1][n2][n3];
        
        if(s1[n1] == s2[n2] && s2[n2] == s3[n3]){
            int ans =  1+find(s1,s2,s3,n1-1,n2-1,n3-1);
            memo[n1][n2][n3] = ans;
            return ans;
        }
        
        int ans = Math.max(find(s1,s2,s3,n1-1,n2,n3),Math.max(find(s1,s2,s3,n1,n2-1,n3),find(s1,s2,s3,n1,n2,n3-1)));
        memo[n1][n2][n3] = ans;
        return ans;
        
    }
    
}