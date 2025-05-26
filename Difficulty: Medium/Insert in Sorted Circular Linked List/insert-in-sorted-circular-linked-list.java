/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    public Node sortedInsert(Node head, int data) {
        // code here
        Node ptr = head;
        if(ptr.data >= data){
            Node newNode = new Node(data);
            newNode.next = ptr;
            ptr = newNode;
            // Node prev = newNode;
            while(ptr.data <= ptr.next.data){
                ptr = ptr.next;
            }
            ptr.next = newNode;
            return newNode;
        }
        while(ptr.data <= ptr.next.data && ptr.next.data < data){
            ptr = ptr.next;
        }
        Node newNode = new Node(data);
        Node next = ptr.next;
        ptr.next = newNode;
        ptr = newNode;
        newNode.next = next;
        return head;
    }
}