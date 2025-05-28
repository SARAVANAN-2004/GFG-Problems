class Solution {
    class obj{
        int v,w;
        double r;
        public obj(int v,int w){
            this.v = v;
            this.w = w;
            this.r = ((double)v/w);
        }
    }
    double fractionalKnapsack(int[] values, int[] weights, int cap) {
        // code here
        PriorityQueue<obj> pq = new PriorityQueue<>((a,b)->Double.compare(b.r,a.r));
        for(int i = 0;i<values.length;i++){
            pq.add(new obj(values[i],weights[i]));
        }
        double sum = 0;
        while(!pq.isEmpty()){
            
            int v = pq.peek().v;
            int w = pq.peek().w;
            
            // System.out.println(pq.peek().v+" "+pq.peek().w+" "+pq.peek().r+" "+cap);
            pq.poll();
            if(w <= cap){
                sum += v;
                cap -= w;
                // System.out.println("cap "+cap);
            }else{
                double val = ((double)v/w)*cap;
                cap = 0;
                // System.out.println("val "+val);
                sum += val;
                return sum;
            }
            // System.out.println("sum "+sum);
            
        }
        return sum;
        
    }
}