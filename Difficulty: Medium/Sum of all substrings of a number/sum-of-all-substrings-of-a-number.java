class Solution {
    
    public static int sumSubstrings(String s) {
        // code here
        int sum = 0;
        int n = s.length();
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n+1;j++){
                int  num = Integer.valueOf(s.substring(i,j));
                sum+=num;
            }
        }
        return sum;
    }
}