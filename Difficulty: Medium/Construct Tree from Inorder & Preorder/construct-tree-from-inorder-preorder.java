//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Node root = null;

            // Read inorder array
            String[] inorderStr = (br.readLine()).trim().split(" ");
            int inorder[] = new int[inorderStr.length];
            for (int i = 0; i < inorderStr.length; i++) {
                inorder[i] = Integer.parseInt(inorderStr[i]);
            }

            // Read preorder array
            String[] preorderStr = (br.readLine()).trim().split(" ");
            int preorder[] = new int[preorderStr.length];
            for (int i = 0; i < preorderStr.length; i++) {
                preorder[i] = Integer.parseInt(preorderStr[i]);
            }

            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder);
            postOrder(root);
            System.out.println();
        }
    }

    // Function to print postorder traversal of the tree
    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/

class Solution {
    
    static Node buildTreeRecur(Map<Integer, Integer> mp, int[] preorder, 
                               int[] preIndex, int left, int right) {

        // For empty inorder array, return null
        if (left > right)
            return null;

        int rootVal = preorder[preIndex[0]];
        preIndex[0]++;

        // create the root Node
        Node root = new Node(rootVal);

        // find the index of Root element in the in-order array.
        int index = mp.get(rootVal);

        // Recursively create the left and right subtree.
        root.left = buildTreeRecur(mp, preorder, preIndex, left, index - 1);
        root.right = buildTreeRecur(mp, preorder, preIndex, index + 1, right);

        return root;
    }

    // Function to construct tree from its inorder and preorder traversals
    static Node buildTree(int[] inorder, int[] preorder) {

        // Hash map that stores index of a root element in inorder array
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            mp.put(inorder[i], i);

        int[] preIndex = {0};
        return buildTreeRecur(mp, preorder, preIndex, 0, inorder.length - 1);
    }
    
}
