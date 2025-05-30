/*
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
} */
class Solution {
    int maxi = -1;
    public int findMaxFork(Node root, int k) {
        // code here.
        if(root  == null) return maxi;
        if(root.data == k) return k;
        else if(root.data <k ) {
            maxi = Math.max(maxi,root.data);
            return findMaxFork(root.right ,k);
        }
       
        return findMaxFork(root.left,k);
        
    }
}