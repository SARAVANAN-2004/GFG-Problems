class Solution {
    public int minimumCoins(int[] arr, int k) {
        // code here
         Arrays.sort(arr);
        int n = arr.length;

        // Prefix sum of coins
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        int minRemove = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int upperLimit = x + k;

            // Find index of first element > upperLimit
            int left = i, right = n;
            while (left < right) {
                int mid = (left + right) / 2;
                if (arr[mid] <= upperLimit) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            int index = left; // first element > upperLimit

            long coinsBefore = prefixSum[i]; // remove all piles before i
            long coinsAfter = prefixSum[n] - prefixSum[index]; // reduce higher piles
            long reduceCoins = coinsAfter - (long)(n - index) * upperLimit;

            int totalRemoved = (int)(coinsBefore + reduceCoins);
            minRemove = Math.min(minRemove, totalRemoved);
        }

        return minRemove;
    }
}
