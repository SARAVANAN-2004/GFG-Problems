class Solution {
    public int substrCount(String s, int k) {
        // code here
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<k;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int cnt = 0;
        for(int i = k;i<s.length();i++){
        if(map.size() == k-1) cnt++;
            // System.out.println(map);
         map.put(s.charAt(i-k),map.getOrDefault(s.charAt(i-k),0)-1);
         
          map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
          
         if(map.get(s.charAt(i-k)) == 0){
             map.remove(s.charAt(i-k));
         }
        //  System.out.println(map);
        
         
         
        }
        // System.out.println(map);
        if(map.size() == k-1) cnt++;
        return cnt;
    }
}