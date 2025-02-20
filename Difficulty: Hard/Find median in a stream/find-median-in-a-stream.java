//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    PriorityQueue<Integer> left ;
    PriorityQueue<Integer> right ;
    
    void insert(int val){
        if(left.size() == right.size()){
            left.add(val);
            right.add(left.poll());
        }else{
            right.add(val);
            left.add(right.poll());
        }
    }
    double median(){
        if(left.size() == right.size()){
            return (left.peek() + right.peek())/2.0;
        }else{
            return right.peek();
        }
    }
    public ArrayList<Double> getMedian(int[] arr) {
        // code here
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
        ArrayList<Double> res = new ArrayList<>();
        for(int val:arr){
            insert(val);
            res.add(median());
        }
        return res;
        
        
    }
}