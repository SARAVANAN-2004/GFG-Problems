class Solution {
    int smallestDivisor(int[] arr, int k) {
        // Code here
        int l = 1, r = arr[0];
        for(int i:arr){
            r = Math.max(i,r);
        }
        
        int res = r;
        while(l<=r){
            int mid = (l+r)/2;
            
            if(solve(arr,mid,k)){
                res = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return res;
    }
    
    boolean solve(int[] arr,int mid,int k){
        int cnt = 0;
        for(int i :arr){
            int val = (int)Math.ceil((double)i/mid);
            // System.out.println(val+" "+i+" "+mid);
            cnt += val;
            if(cnt > k) return false;
        }
        return true;
    }
}