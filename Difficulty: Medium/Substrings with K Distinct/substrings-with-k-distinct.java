// User function Template for Java

class Solution {
    int countSubstr(String s, int k) {
        
        return count(s,k) - count(s,k-1); 
    }
    int count(String s, int k) {
        // your code here
        char[] arr = s.toCharArray();
        int l = 0,n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        int cnt  = 0;
        for(int r = 0;r<n;r++){
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            if(map.size() > k){
                while(map.size() > k){
                    int val = map.get(arr[l]);
                    val--;
                    if(val == 0) map.remove(arr[l]);
                    else map.put(arr[l],val);
                    l++;
                }
            }
            cnt += r-l+1;
          
        }
        
        return cnt;
    }
}