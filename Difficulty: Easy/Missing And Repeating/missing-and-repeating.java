// User function Template for Java

class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int n = arr.length;
        int[] vis =new int[n+1];
        long acc = 0;
        long sum  = 0;
        ArrayList<Integer> ans  = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(vis[arr[i]] == 1){
                ans.add(arr[i]);
            }else{
                sum ^= arr[i];
                vis[arr[i]] = 1;
            }
            acc ^= i+1;
        }
        ans.add((int)(acc ^ sum));
        return ans;
        
    }
}
