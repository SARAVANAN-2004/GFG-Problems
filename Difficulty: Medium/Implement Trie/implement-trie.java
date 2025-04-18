//{ Driver Code Starts
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// } Driver Code Ends

// User function Template for Java
class Node{
    Node nde[]= new Node[26];
    boolean end = false;
    Node get(char ch)
    {
        return nde[ch-'a'];
    }
    boolean isNode(char ch)
    {
        return nde[ch-'a']!=null;
    }
    void put(char ch,Node node)
    {
        nde[ch-'a']= node;
    }
    void setEnd()
    {
        end = true;
    }
    boolean isEnd()
    {
        return end;
    }
}
class Trie {

    Node root;
    public Trie() {
        
        root = new Node();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        Node node = root;
        for(int i = 0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(!node.isNode(ch))
            {
                node.put(ch,new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        Node node = root;
        for(int i =0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(!node.isNode(ch))return false;
            node = node.get(ch);
        }
        return node.isEnd();
    }

    // Check if a prefix exists in the Trie
    public boolean isPrefix(String word) {
        Node node = root;
        for(int i =0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(!node.isNode(ch))return false;
            node = node.get(ch);
        }
        return true;
    }
}


//{ Driver Code Starts.

public class GfG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            int q = sc.nextInt();
            sc.nextLine();
            List<Boolean> ans = new ArrayList<>();
            Trie ob = new Trie();

            for (int i = 0; i < q; i++) {
                int x = sc.nextInt();
                String s = sc.next();
                if (i != q - 1) sc.nextLine();

                if (x == 1) {
                    ob.insert(s);
                } else if (x == 2) {
                    ans.add(ob.search(s));
                } else if (x == 3) {
                    ans.add(ob.isPrefix(s));
                }
            }

            for (Boolean result : ans) {
                System.out.print(result + " ");
            }
            System.out.println();
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends