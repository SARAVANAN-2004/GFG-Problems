class Solution {
    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        int[] map = new int[n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j] == 0){
                    
                }else{
                    if(i != j){
                        map[j]++;
                        map[i]--;
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(map));
        for(int i = 0;i<n;i++){
            if(map[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}