class Solution {
    int countStrings(String s) {
        // code here
        int[] arr = new int[26];
        int cnt = 0;
        boolean valid = true;
        for(int i = s.length()-1;i>=0;i--){
            int val = 0;
            char ch = s.charAt(i);
            for(int j = 0;j<26;j++){
                if(ch-'a' != j){
                    val += arr[j];
                }else if(arr[j] != 0 && valid){
                    valid = false;
                    val++;
                }
            }
            cnt += val;
            arr[ch-'a']++;
        }
        return cnt;
        
    }
}