
class Solution {
    public int longestCommonSum(int[] a1, int[] a2) {
        // Code here
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        int sum1 = 0, sum2 = 0;
        for(int i = 0;i<a1.length;i++){
            sum1+=a1[i];
            sum2+=a2[i];
            int cur = sum1 - sum2;
            
            if(cur == 0){
                res = Math.max(res,i+1);
            }else{
                if(map.containsKey(cur)){
                    res = Math.max(res,i-map.get(cur));
                }else{
                    map.put(cur,i);
                }
            }
        }
        return res;
    }
}