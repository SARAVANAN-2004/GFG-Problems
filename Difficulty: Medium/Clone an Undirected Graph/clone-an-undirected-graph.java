//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.math.*;
import java.util.*;

class Node {
    int val;
    ArrayList<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

class GFG {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        Integer nextInt() { return Integer.parseInt(next()); }
    }

    static ArrayList<Node> bfs(Node src) {
        ArrayList<Node> ans = new ArrayList<>();
        HashSet<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(src);
        visited.add(src);

        while (!q.isEmpty()) {
            Node u = q.poll();
            ans.add(u);
            ArrayList<Node> v = u.neighbors;
            for (Node x : v) {
                if (!visited.contains(x)) {
                    visited.add(x);
                    q.add(x);
                }
            }
        }

        return ans;
    }

    static boolean checkedClone(Node prev, Node new1) {
        ArrayList<Node> prevAns = bfs(prev);
        ArrayList<Node> newAns = bfs(new1);
        for (int i = 0; i < prevAns.size(); i++) {
            if (prevAns.get(i) == newAns.get(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Node root = null;
            Node v[] = new Node[n];
            for (int i = 0; i < n; i++) v[i] = new Node(i);
            Solution ob = new Solution();
            for (int i = 0; i < n; i++) {
                ArrayList<Node> li = new ArrayList<>();
                String arr[] = sc.nextLine().split(" ");
                for (String s : arr) {
                    li.add(v[Integer.parseInt(s)]);
                }
                v[i].neighbors = li;
            }
            ArrayList<Node> prev = bfs(v[0]);
            Node ans = ob.cloneGraph(v[0]);
            ArrayList<Node> now = bfs(ans);
            out.println(checkedClone(v[0], ans) ? "true" : "false");

            out.println("~");
        }
        out.flush();
    }
}
// } Driver Code Ends


// User function Template for Java

/*
    class Node{
        int val;
        ArrayList<Node> neighbors;
        public Node(){
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val){
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors){
            this.val = val;
            this.neighbors = neighbors;
        }
    }
*/
class Solution {
    Node cloneGraph(Node node) {
        // code here
        if (node == null) return null;

        Map<Node, Node> mp = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        Node clone = new Node(node.val);
        mp.put(node, clone);
        q.offer(node);

        while (!q.isEmpty()) {
            Node current = q.poll();

            for (Node neighbor : current.neighbors) {

                if (!mp.containsKey(neighbor)) {
                    mp.put(neighbor, new Node(neighbor.val));
                    q.offer(neighbor);
                }

                mp.get(current).neighbors.add(mp.get(neighbor));
            }
        }

        return mp.get(node);
    }
    
    Node buildGraph() {
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Node node3 = new Node(2);
        Node node4 = new Node(3);

        node1.neighbors.addAll(new ArrayList<>
                    (Arrays.asList(node2, node3)));
        node2.neighbors.addAll(new ArrayList<>
                    (Arrays.asList(node1, node3)));
        node3.neighbors.addAll(new ArrayList<>
                    (Arrays.asList(node1, node2, node4)));
        node4.neighbors.addAll(new ArrayList<>
                    (Arrays.asList(node3)));

        return node1;
    }
    boolean compareGraphs(Node n1, Node n2, 
                             HashMap<Node, Node> visited) {
        if (n1 == null || n2 == null)
            return n1 == n2;

        if (n1.val != n2.val || n1 == n2)
            return false;

        visited.put(n1, n2);

        if (n1.neighbors.size() != n2.neighbors.size())
            return false;

        for (int i = 0; i < n1.neighbors.size(); i++) {
            Node neighbor1 = n1.neighbors.get(i);
            Node neighbor2 = n2.neighbors.get(i);

            if (visited.containsKey(neighbor1)) {
                if (visited.get(neighbor1) != neighbor2)
                    return false;
            } else {
                if (!compareGraphs(neighbor1, neighbor2, visited))
                    return false;
            }
        }

        return true;
    }
}