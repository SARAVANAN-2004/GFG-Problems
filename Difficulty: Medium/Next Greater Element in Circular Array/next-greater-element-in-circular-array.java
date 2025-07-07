class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        Stack<Integer> stk = new Stack<>();
        int n = arr.length;
        for(int i = n-1;i>= 0;i--){
            while(!stk.isEmpty() && stk.peek()<= arr[i]){
                stk.pop();
            }
            stk.push(arr[i]);
        }
        // System.out.println(stk);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = n-1;i>= 0;i--){
            while(!stk.isEmpty() && stk.peek()<= arr[i]){
                stk.pop();
            }
            if(stk.isEmpty()) ans.add(-1);
            else ans.add(stk.peek());
            stk.push(arr[i]);
        }
        int i = 0, j = n-1;
        while(i < j){
            int t = ans.get(i);
            ans.set(i,ans.get(j));
            ans.set(j,t);
            i++;
            j--;
        }
        return ans;
    }
}