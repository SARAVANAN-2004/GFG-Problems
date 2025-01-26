//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int isCircle(String[] arr) {
        int n = arr.length;

        // Initialize adjacency list, in-degree, and out-degree
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        Map<Character, Integer> outDegree = new HashMap<>();

        // Build the graph
        for (String str : arr) {
            char start = str.charAt(0);
            char end = str.charAt(str.length() - 1);

            // Update adjacency list
            graph.computeIfAbsent(start, k -> new ArrayList<>()).add(end);

            // Update in-degree and out-degree
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
        }

        // Check if in-degree == out-degree for every character
        for (char ch : outDegree.keySet()) {
            if (!inDegree.containsKey(ch) || !inDegree.get(ch).equals(outDegree.get(ch))) {
                return 0; // Not possible to form a circle
            }
        }

        // Check if the graph is strongly connected
        return isStronglyConnected(graph, arr[0].charAt(0)) ? 1 : 0;
    }

    private boolean isStronglyConnected(Map<Character, List<Character>> graph, char startNode) {
        // Check if all reachable nodes can be visited from the start node
        Set<Character> visited = new HashSet<>();
        dfs(graph, startNode, visited);

        // Verify all nodes with outgoing edges are visited
        for (char node : graph.keySet()) {
            if (!visited.contains(node)) {
                return false;
            }
        }

        // Reverse the graph and check again
        Map<Character, List<Character>> reversedGraph = reverseGraph(graph);
        visited.clear();
        dfs(reversedGraph, startNode, visited);

        // Verify all nodes with outgoing edges are visited in the reversed graph
        for (char node : graph.keySet()) {
            if (!visited.contains(node)) {
                return false;
            }
        }

        return true;
    }

    private void dfs(Map<Character, List<Character>> graph, char node, Set<Character> visited) {
        if (visited.contains(node)) return;
        visited.add(node);

        if (graph.containsKey(node)) {
            for (char neighbor : graph.get(node)) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    private Map<Character, List<Character>> reverseGraph(Map<Character, List<Character>> graph) {
        Map<Character, List<Character>> reversedGraph = new HashMap<>();
        for (char u : graph.keySet()) {
            for (char v : graph.get(u)) {
                reversedGraph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
            }
        }
        return reversedGraph;
    }
}