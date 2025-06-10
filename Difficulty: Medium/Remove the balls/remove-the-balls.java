class Solution {
    public int findLength(int[] color, int[] radius) {
        // code here
        Stack<int[]> stk = new Stack<>();
        for(int i = 0;i<color.length;i++){
            if(!stk.isEmpty() && stk.peek()[0] == color[i] && stk.peek()[1] == radius[i]){
                stk.pop();
            }else{
                stk.push(new int[]{color[i],radius[i]});
            }
        }
        return stk.size();
    }
}