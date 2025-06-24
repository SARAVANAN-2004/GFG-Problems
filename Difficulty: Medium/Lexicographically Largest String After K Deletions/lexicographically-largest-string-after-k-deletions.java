class Solution {
    public static String maxSubseq(String s, int k) {
        // code here
         int n = s.length();
        Stack<Character> stack = new Stack<>();
        String result = "";
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            while(!stack.isEmpty() && k>0 && stack.peek()<ch){
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        while(!stack.isEmpty() && k>0){
            stack.pop();
            k--;
        }
        while(!stack.isEmpty()){
            result = stack.pop() + result;
        }
        return result;
        
    }
}