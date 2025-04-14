//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    public static boolean dfs(int u, int[][] graph, int[] vis, int[] rec, 
                                          StringBuilder ans) {
        
        // Mark as visited and add to recursion stack
        vis[u] = rec[u] = 1; 

        for (int v = 0; v < 26; v++) {
            if (graph[u][v] == 1) {
                if (vis[v] == 0) {
                    if (!dfs(v, graph, vis, rec, ans))
                        return false;
                } else if (rec[v] == 1) {
                    
                    // Cycle detected
                    return false;
                }
            }
        }
        // Append after visiting dependencies
        ans.append((char) ('a' + u));
        
        // Remove from recursion stack
        rec[u] = 0; 
        return true;
    }

    // Function to find the correct order of characters 
    // in an alien dictionary
    public static String findOrder(String[] words) {
        int[][] graph = new int[26][26];
        int[] exist = new int[26];
        int[] vis = new int[26];
        int[] rec = new int[26];
        StringBuilder ans = new StringBuilder();

        // Mark characters that appear
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                exist[ch - 'a'] = 1;
            }
        }


        // Build the graph
        for (int i = 0; i + 1 < words.length; i++) {
            String a = words[i], b = words[i + 1];
            int n = a.length(), m = b.length(), ind = 0;

            while (ind < n && ind < m && a.charAt(ind) == b.charAt(ind))
                ind++;

            if (ind != n && ind == m)
                // Invalid case
                return ""; 

            if (ind < n && ind < m)
                graph[a.charAt(ind) - 'a'][b.charAt(ind) - 'a'] = 1;
        }

        for (int i = 0; i < 26; i++) {
            if (exist[i] == 1 && vis[i] == 0) {
                if (!dfs(i, graph, vis, rec, ans)) {
                    return "";
                }
            }
        }
        // Reverse to get correct order
        return ans.reverse().toString(); 
    }

}


//{ Driver Code Starts.

public class GFG {
    private static boolean validate(String[] original, String order) {
        Map<Character, Integer> mp = new HashMap<>();
        for (String word : original) {
            for (char ch : word.toCharArray()) {
                mp.put(ch, 1);
            }
        }
        for (char ch : order.toCharArray()) {
            if (!mp.containsKey(ch)) {
                return false;
            }
            mp.remove(ch);
        }
        if (!mp.isEmpty()) {
            return false;
        }

        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            indexMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < original.length - 1; i++) {
            String a = original[i];
            String b = original[i + 1];
            int k = 0, n = a.length(), m = b.length();

            while (k < n && k < m && a.charAt(k) == b.charAt(k)) {
                k++;
            }

            if (k < n && k < m &&
                indexMap.get(a.charAt(k)) > indexMap.get(b.charAt(k))) {
                return false;
            }
            if (k != n && k == m) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine()); // Number of test cases

        while (t-- > 0) {
            String[] words = sc.nextLine().split(" ");
            String[] original = Arrays.copyOf(words, words.length);

            Solution ob = new Solution();
            String order = ob.findOrder(words);

            if (order.isEmpty()) {
                System.out.println("\"\"");
            } else {
                System.out.println(validate(original, order) ? "true" : "false");
            }
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends