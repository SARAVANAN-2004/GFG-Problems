class Solution {
    public int totalElements(int[] arr) {
        // code here
        int j = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int maxi = 0;
        for(int i = 0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            if(map.size() <= 2){
                maxi = Math.max(maxi,i - j+1);
                
            }
            while(map.size() > 2){
                map.put(arr[j],map.get(arr[j]) -1);
                if(map.get(arr[j]) == 0){
                    map.remove(arr[j]);
                }
                j++;
            }
            
        }
        return maxi;
    }
}