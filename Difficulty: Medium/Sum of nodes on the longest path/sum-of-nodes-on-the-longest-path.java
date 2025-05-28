/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */
class Solution {
    public int sumOfLongRootToLeafPath(Node root) {
        // code here
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        int maxi = root.data;
        while(!que.isEmpty()){
            int size = que.size();
            int max = que.peek().data;
            for(int i = 0;i<size;i++){
                Node cur = que.poll();
                max = Math.max(max,cur.data);
                if(cur.left != null){
                    cur.left.data += cur.data;
                    que.add(cur.left);
                }
                if(cur.right != null){
                    cur.right.data += cur.data;
                    que.add(cur.right);
                }
            }
            maxi = max;
        }
        return maxi;
    }
}