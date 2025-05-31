class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = matrix.length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                pq.add(matrix[i][j]);
            }
        }
        for(int i = 0;i<k-1;i++){
            pq.poll();
        }
        return pq.poll();
    }
}