class Solution {
    public int minCost(int[] heights, int[] cost) {
        // code here
        int l = heights[0], r = heights[0];
        int n  = cost.length;
        for(int i :heights){
            r  = Math.max(r,i);
            l = Math.min(l,i);
        }
        
        while(l <= r){
            int m = (l+r)/2;
            
            int cur = find(m,heights,cost);
            int prev = find(m-1,heights,cost);
            int next = find(m+1,heights,cost);
            
            if(cur <= prev && cur <= next) return cur;
            
            else if(cur > prev && next > cur) r = m-1;
            else l = m+1;
        }
        
        return l;
    }
    
    int find(int m,int[] arr,int[] cost){
        
        int n = arr.length;
        // if(m < 0 || m > n) return Integer.MAX_VALUE;
        // System.out.println("m "+m);
        int sum = 0;
        for(int i = 0;i<n;i++){
            int c = Math.abs(m - arr[i]) * cost[i];
            // System.out.println(Math.abs(m - arr[i]) * cost[i]);
            sum += c;
        }
        // System.out.println("sum "+sum);
        return sum;
    }
}
