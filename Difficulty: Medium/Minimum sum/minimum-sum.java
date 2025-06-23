class Solution {
    String minSum(int[] arr) {
        // code here
        StringBuilder s = new StringBuilder();
        Arrays.sort(arr);
        int carry = 0;
        
        for(int i = arr.length-1;i>=0;i-=2){
            int sum = carry + arr[i] + (i-1 >= 0? arr[i-1]:0);
            int v = sum%10;
            carry = sum / 10;
            
            s.append(v);
            
            
            
        }
        if(carry > 0) s.append(carry);
        s.reverse();
        String str=  s.toString();
        int i = 0;
        while(i < str.length() && str.charAt(i) == '0'){
            i++;
        }
        
        return s.toString().substring(i,s.length());
    }
}
