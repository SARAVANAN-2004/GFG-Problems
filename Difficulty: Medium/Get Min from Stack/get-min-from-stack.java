//{ Driver Code Starts
import java.util.*;

class Get_Min_From_Stack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        while (T-- > 0) {
            int q = sc.nextInt(); // Number of queries
            Solution g = new Solution();

            while (q-- > 0) {
                int qt = sc.nextInt();

                if (qt == 1) {
                    int att = sc.nextInt();
                    g.push(att);
                } else if (qt == 2) {
                    g.pop(); // Just call pop(), do not print anything
                } else if (qt == 3) {
                    System.out.print(g.peek() + " "); // Print top element
                } else if (qt == 4) {
                    System.out.print(g.getMin() + " "); // Print minimum element
                }
            }
            System.out.println("\n~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    Stack<int[]> stk;
    public Solution() {
        stk = new Stack<>();
    }

    // Add an element to the top of Stack
    public void push(int x) {
        // code here
        if(stk.isEmpty()){
            stk.push(new int[]{x,x});
        }else{
            stk.push(new int[]{x,Math.min(x,stk.peek()[1])});
        }
    }

    // Remove the top element from the Stack
    public void pop() {
        // code here
        if(stk.isEmpty()) return;
        stk.pop();
        
    }

    // Returns top element of the Stack
    public int peek() {
        if(stk.isEmpty()) return -1;
        // code here
        return stk.peek()[0];
    }

    // Finds minimum element of Stack
    public int getMin() {
        // code here
        if(stk.isEmpty()) return -1;
        return stk.peek()[1];
    }
}