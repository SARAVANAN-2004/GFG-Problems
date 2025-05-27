class Solution {
    
    void func(int st, int end, int[] pre, ArrayList<Integer>res)
    {
        if(st==end)
        {
            res.add(pre[st]);
            return;
        }
            
        if(st>end)
        return;
        
        int k = 0;
        for(k = st; k<=end; k++)
        {
            if(pre[st]<pre[k])
            break;
        }
        
        func(st+1, k-1, pre, res);  //left subarray call
        func(k, end, pre, res);  // right subarray call
        
    }
    
    public ArrayList<Integer> leafNodes(int[] pre) {
        // code here
        
        ArrayList<Integer> res = new ArrayList<>();
       
       func(0, pre.length-1, pre, res);
        return res;
    }
}

