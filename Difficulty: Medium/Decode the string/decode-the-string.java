//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s = in.readLine();

            Solution ob = new Solution();
            out.println(ob.decodeString(s));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends



class Solution {
    static String decodeString(String s) {
        // code here
        Stack<String> stk = new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch == ']'){
                StringBuilder sb = new StringBuilder();
                while(!stk.peek().equals("[")){
                    sb.insert(0,stk.pop());
                }
                stk.pop();
                StringBuilder ans = new StringBuilder();
                int n = Integer.parseInt(stk.pop());
                for(int i = 0;i<n;i++){
                    ans.append(sb.toString());
                }
                stk.push(ans.toString());
            }else if(Character.isDigit(ch)){
                if(!stk.isEmpty() && stk.peek().chars().allMatch(Character::isDigit)){
                    stk.push(stk.pop()+ch);
                }else{
                    stk.push(ch+"");
                }
            }else{
                stk.push(ch+"");
            }
        }
        StringBuilder res = new StringBuilder();
        for(String str:stk){
            res.append(str);
        }
        return res.toString();
    }
}