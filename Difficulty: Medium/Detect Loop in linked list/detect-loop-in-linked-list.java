//{ Driver Code Starts
// Initial template code for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GFG {
    public static void makeLoop(Node head, Node tail, int x) {
        if (x == 0) return;

        Node curr = head;
        for (int i = 1; i < x; i++) curr = curr.next;

        tail.next = curr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            if (!input.isEmpty()) {
                String[] numbers = input.split("\\s+");
                for (String num : numbers) {
                    if (!num.isEmpty()) {
                        arr.add(Integer.parseInt(num));
                    }
                }
            }

            int pos = Integer.parseInt(br.readLine().trim());

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); ++i) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
                makeLoop(head, tail, pos);
            }

            Solution x = new Solution();
            if (x.detectLoop(head))
                System.out.println("true");
            else
                System.out.println("false");
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function template for JAVA

/* Node is defined as

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

class Solution {
    // Function to check if the linked list has a loop.
    static boolean detectLoop(Node head) {
        HashSet<Node> st = new HashSet<>();

        while (head != null) {

            // If this node is already present
            // in hashmap it means there is a cycle
            if (st.contains(head))
                return true;

            // If we are seeing the node for
            // the first time, insert it in hash
            st.add(head);

            head = head.next;
        }
        return false;
    }
}