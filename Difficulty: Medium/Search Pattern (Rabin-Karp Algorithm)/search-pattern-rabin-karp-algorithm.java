class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        // Code here
        char[] str = txt.toCharArray();
        char[] key = pat.toCharArray();
        
        int[] lps = new int[key.length];
        int len = 0;
        for(int i = 1;i<key.length;){
            if(key[len] == key[i]){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len == 0){
                    
                    lps[i] = 0;
                    i++;
                }else{
                    len = lps[len-1];
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int ki = 0;
        for(int i = 0;i<str.length;){
            if(key[ki] == str[i]){
                ki++;
                i++;
                if(ki == key.length){
                    ans.add(i-key.length+1);
                    ki = lps[ki-1];
                }
            }else{
                if(ki == 0){
                    i++;
                }else{
                    ki = lps[ki-1];
                }
            }
        }
        return ans;
    }
}