class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        Map<Character,Integer> map = new HashMap<>();
        int maxi = -1;
        int i = 0;int j = 0;
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(i < j && map.size() > k){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i)) == 0){
                    map.remove(s.charAt(i));
                }
                i++;
            }
            if(map.size() == k){
                maxi = Math.max(maxi,j-i+1);
            }
            j++;
        }
        return maxi;
    }
}