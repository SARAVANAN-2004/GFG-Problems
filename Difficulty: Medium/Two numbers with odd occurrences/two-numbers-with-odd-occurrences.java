//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution
{
    public int[] twoOddNum(int Arr[], int N)
    {
        // code here
        int val = 0;
        Set<Integer> set = new HashSet<>();
        for(int i:Arr){
            val ^= i;
            set.add(i);
        }
        int distinguish = val & -val;
        int x1 = 0, x2 = 0;
        for(int i:Arr){
            if((i & distinguish) > 0){
                x1 ^= i;
            }else{
                x2 ^= i;
            }
        }
        int[] res = new int[2];
        return x1 > x2 ? new int[]{x1,x2} : new int[]{x2,x1};
    }
}