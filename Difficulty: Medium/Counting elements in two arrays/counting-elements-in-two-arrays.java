class Solution {
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        // code here
        Arrays.sort(b);
        Map<Integer,Integer> map  = new HashMap<>();
        for(int i = 0;i<b.length;i++){
            map.put(b[i],i);
        }
        int n = a.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            ans.add( getAns(b,a[i]));
        }
        return ans;
    }
    
    public static int getAns(int[] b,int t){
        
        int l = 0, r = b.length-1;
        int res = 0;
        if(b[0] > t) return 0;
        while(l <=r){
            int mid = (l+r)/2;
            if(b[mid] <= t){
                res = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        // System.out.println(res+" "+t+" "+Arrays.toString(b));
        return res+1;
    }
}