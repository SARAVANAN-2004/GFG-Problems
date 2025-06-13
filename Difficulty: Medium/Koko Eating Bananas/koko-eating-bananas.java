class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        int l =1, r = arr[0];
        for(int i:arr){
            
            r = Math.max(r,i);
        }
        
        int res = r;
        while(l<r){
            int mid = (l+r)/2;
            if(valid(mid,arr,k)){
                res = mid;
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return res;
    }
    
    boolean valid(int mid,int[] arr,int k){
        int cnt = 0;
        
        for(int i:arr){
            cnt += Math.ceil((double)i/mid);
            if(cnt > k){
                return false;
            }
        }
        return true;
    }
    
}
