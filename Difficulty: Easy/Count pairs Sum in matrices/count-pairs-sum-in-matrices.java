class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        // code here
        
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<mat2.length; i++)
        {
            for(int j=0; j<mat2[0].length; j++)
            {
                set.add(mat2[i][j]);
            }
        }
        int count = 0;
         for(int i=0; i<mat1.length; i++)
        {
            for(int j=0; j<mat1[0].length; j++)
            {
                if(set.contains(x - mat1[i][j]))
                 count++;   
            }
        }
        return count;
        
    }
}