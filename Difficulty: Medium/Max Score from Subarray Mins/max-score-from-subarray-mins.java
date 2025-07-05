class Solution {
    public int maxSum(int arr[]) {
        // code here
        
        int n = arr.length;

        // find two consecutive elements with maximum sum
        int res = arr[0] + arr[1];
        for (int i = 1; i < n - 1; i++)
            res = Math.max(res, arr[i] + arr[i + 1]);

        return res;
    }
}