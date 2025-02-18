//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    class pair{
        int a;
        int b;
        double val;
        public pair(int a,int b){
            this.a = a;
            this.b = b;
            this.val = Math.sqrt((a*a)+(b*b));
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        // Your code here
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->Double.compare(a.val,b.val));
        for(int[] a:points){
            pq.add(new pair(a[0],a[1]));
        }
        int[][] res = new int[k][2];
        for(int i = 0;i<k;i++){
            res[i][0] = pq.peek().a;
            res[i][1] = pq.peek().b;
            pq.poll();
        }
        return res;
    }
}

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] points = new int[n][2];
            for (int i = 0; i < n; i++) {
                points[i][0] = scanner.nextInt();
                points[i][1] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int[][] ans = solution.kClosest(points, k);

            Arrays.sort(ans, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });
            for (int[] point : ans) {
                System.out.println(point[0] + " " + point[1]);
            }
            System.out.println("~");
        }

        scanner.close();
    }
}
// } Driver Code Ends