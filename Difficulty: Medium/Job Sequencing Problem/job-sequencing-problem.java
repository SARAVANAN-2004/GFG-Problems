//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n = deadline.length;

        // total job count which is done
        int cnt = 0;

        // total profit earned
        int totProfit = 0;

        // pair the profit and deadline of all the jobs together
        ArrayList<int[]> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new int[]{profit[i], deadline[i]});
        }

        // sort the jobs based on profit in decreasing order
        jobs.sort((a, b) -> Integer.compare(b[0], a[0]));

        // array to check time slot for job
        int[] slot = new int[n];

        for (int i = 0; i < n; i++) {
            int start = Math.min(n, jobs.get(i)[1]) - 1;
            for (int j = start; j >= 0; j--) {

                // if slot is empty
                if (slot[j] == 0) {
                    slot[j] = 1;
                    cnt++;
                    totProfit += jobs.get(i)[0];
                    break;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(cnt);
        result.add(totProfit);
        return result;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends