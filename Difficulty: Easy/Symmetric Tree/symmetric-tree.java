/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/
class Solution {
    public boolean isSymmetric(Node root) {
        // Code here
        if(root == null) return true;
        return valid(root.left,root.right);
    }
    
    boolean valid(Node root1,Node root2){
        if(root1 == null && root2 == null) return true;
        
        if(root1 == null || root2 == null) return false;
        
        if(root1.data != root2.data) return false;
        
        return valid(root1.left,root2.right) && valid(root1.right,root2.left);
    }
}