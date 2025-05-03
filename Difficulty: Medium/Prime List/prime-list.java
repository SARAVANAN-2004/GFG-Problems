//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    Node next;
    int val;

    public Node(int data) {
        val = data;
        next = null;
    }
}

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            Node head, tail;
            String s[] = in.readLine().trim().split(" ");
            int num = Integer.parseInt(s[0]);
            head = new Node(num);
            tail = head;
            for (int i = 1; i < s.length; i++) {
                num = Integer.parseInt(s[i]);
                tail.next = new Node(num);
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node temp = ob.primeList(head);
            while (temp != null) {
                out.print(temp.val + " ");
                temp = temp.next;
            }
            out.println();
            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution {
    Node primeList(Node head) {
        // code here
        Node ptr = head;
        while(ptr != null){
            if(isPrime(ptr.val)){
                ptr = ptr.next;
                
            }else{
                int n = ptr.val;
                int i = 0;
                boolean sm  = false;
                boolean la = false;
                while(!sm && !la){
                    i++;
                    sm = isPrime(n-i);
                    if(!sm){
                        la = isPrime(n+i);
                    }
                }
                if(sm) n = n-i;
                else n+=i;
                ptr.val = n;
                ptr = ptr.next;
            }
        }
        return head;
    }
    
    
    boolean isPrime(int n){
        if(n <= 1) return false;
        for(int i = 2;i*i<=n;i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}