class Solution {
    boolean[][] arr;
    ArrayList<ArrayList<String>> res  = new ArrayList<>();
    public ArrayList<ArrayList<String>> palinParts(String s) {
        // code here
        
        char[] ch = s.toCharArray();
        int n = s.length();
        arr = new boolean[n][n];
        for(int i = 0;i<n;i++){
            arr[i][i] = true;
        }
        
        for(int i = 0;i<n-1;i++){
            if(ch[i] == ch[i+1]){
                arr[i][i+1] = true;
                // arr[i+1] = 1;
            }
        }
        for(int len = 2;len <n;len++){
            for(int i = 0;i+len<n;i++){
                if(ch[i] == ch[i+len]){
                    arr[i][i+len] = arr[i+1][i+len-1];
                }
            }
        }
        
        solve(0,n,s,new ArrayList<>());
        return res;
    }
    public void solve(int c,int n,String s,ArrayList<String> temp){
        if(c == n){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int j = c;j<n;j++){
            
            if(arr[c][j]){
                temp.add(s.substring(c,j+1));
                solve(j+1,n,s,temp);
                temp.remove(temp.size()-1);
            }
        }
       
    }
}
