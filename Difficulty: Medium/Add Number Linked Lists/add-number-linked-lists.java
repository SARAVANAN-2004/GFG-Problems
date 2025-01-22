//{ Driver Code Starts
// driver

import java.io.*;
import java.util.*;


// } Driver Code Ends
/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
     static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
  
    static Node trimLeadingZeros(Node head) {
        while (head != null && head.data == 0) {
            head = head.next;
        }
        return head;
    }

    // Function to add two numbers represented by linked list
    static Node addTwoLists(Node num1, Node num2) {
        Node res = null;
        Node curr = null;
        int carry = 0;
      
        num1 = trimLeadingZeros(num1);
        num2 = trimLeadingZeros(num2);
      
        num1 = reverse(num1);
        num2 = reverse(num2);

        // Iterate till either num1 is not empty or num2 is
        // not empty or carry is greater than 0
        while (num1 != null || num2 != null || carry != 0) {
            int sum = carry;

            // If num1 linked list is not empty, add it to sum
            if (num1 != null) {
                sum += num1.data;
                num1 = num1.next;
            }

            // If num2 linked list is not empty, add it to sum
            if (num2 != null) {
                sum += num2.data;
                num2 = num2.next;
            }
          
            // Create a new node with sum % 10 as its value
            Node newNode = new Node(sum % 10);

            // Store the carry for the next nodes
            carry = sum / 10;

            // If this is the first node, then make this node
            // as the head of the resultant linked list
            if (res == null) {
                res = newNode;
                curr = newNode;
            } else {
                // Append new node to resultant linked list
                // and move to the next node
                curr.next = newNode;
                curr = curr.next;
            }
        }

        // Reverse the resultant linked list to get the
        // required linked list
        return reverse(res);
    }
}

//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends