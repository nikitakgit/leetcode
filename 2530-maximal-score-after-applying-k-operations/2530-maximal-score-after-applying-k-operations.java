class Solution {
    public long maxKelements(int[] nums, int k) {
        long sum=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i:nums)
        {
            pq.offer(i);
        }
        for(int i=0;i<k;i++)
        {
            int val=pq.poll();
            sum+= val;
            
            pq.offer((int)Math.ceil(val/3.0));
        }
        
        return sum;
        
    }
}