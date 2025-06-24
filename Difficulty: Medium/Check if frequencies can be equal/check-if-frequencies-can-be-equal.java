class Solution {
    boolean sameFreq(String s) {
        // code here
        int[] arr = new int[26];
        
        for(char ch:s.toCharArray()){
            arr[ch-'a']++;
            
        }
        Map<Integer,Integer> map  = new HashMap<>();
        for(int i:arr){
            if(i != 0){
                map.put(i,map.getOrDefault(i,0)+1);
            }
            
        }
        // System.out.println(map);
        if(map.size() > 2) return false;
        if(map.size() == 1) return true;
        int a = -1, b= -1;
        for(int i:map.keySet()){
            if(a == -1){
                a = i;
            }else{
                b = i;
            }
        }
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        if(min == 1 && map.get(min) == 1) return true;
        
        if(max -1 == min && map.get(max) == 1) return true;
        return false;
        
        
       
    }
}