class Solution {
    public int catchThieves(char[] arr, int k) {
        // code here
        int n = arr.length;
        List<Integer> theif = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(arr[i] == 'T'){
                theif.add(i);
            }
        }
        int i = 0;
        int t = theif.size();
        int cnt = 0;
        for(int j = 0;j<n;j++){
            if(arr[j] == 'P'){
                while(i < t && Math.abs(theif.get(i) - j) > k && theif.get(i) < j){
                        i++;
                }
                if(i == t) return cnt;
                if(Math.abs(theif.get(i) - j) <= k ){
                    cnt++;
                    i++;
                }
            }
        }
        return cnt;
    }
}