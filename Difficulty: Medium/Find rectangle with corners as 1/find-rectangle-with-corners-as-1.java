class Solution {
    public boolean ValidCorner(int mat[][]) {
        // Code here
        int r = mat.length;
        int c = mat[0].length;
        List<Set<Integer>> sets = new ArrayList<>();
        for(int i = 0;i<r;i++){
            Set<Integer> set = new HashSet<>();
            for(int j = 0;j<c;j++){
                if(mat[i][j] == 1){
                    set.add(j);
                }
            }
            sets.add(set);
        }
        for(int i = 0;i<r;i++){
            Set<Integer> set1 = sets.get(i);
            // System.out.println(set1);
            if(set1.size()>1){
            for(int j = i+1;j<r;j++){
                Set<Integer> set2 = new HashSet<>(sets.get(j));
                // System.out.println(set1+" "+set2);
                set2.retainAll(set1);
                if(set2.size() >1){
                    return true;
                }
                // System.out.println(set1+" "+set2);
            }
            }
        }
        return false;
    }
}