/*
class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
}*/

class Solution {
     void storeAllNodes(Node root, Set<Integer> nodeSet) {
        if (root == null) return;
        nodeSet.add(root.data);
        storeAllNodes(root.left, nodeSet);
        storeAllNodes(root.right, nodeSet);
    }

    // Recursive function to check if a leaf node
    // is dead end or not.
     boolean deadEndRecur(Node root, Set<Integer> nodeSet) {
        if (root == null) return false;
        
        // Check leaf node is dead end or not.
        if (root.left == null && root.right == null) {
            int val = root.data;
            if (nodeSet.contains(val - 1) && nodeSet.contains(val + 1))
                return true;
        }

        return deadEndRecur(root.left, nodeSet) || 
               deadEndRecur(root.right, nodeSet);
    }

     boolean isDeadEnd(Node root) {
        Set<Integer> nodeSet = new HashSet<>();
        
        // to handle case when node value is 1
        nodeSet.add(0);

        storeAllNodes(root, nodeSet);
        return deadEndRecur(root, nodeSet);
    }
}