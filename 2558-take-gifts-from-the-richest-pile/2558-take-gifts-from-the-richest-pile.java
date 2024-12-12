class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i:gifts)
        {
            pq.add(i);
        }
        
        while(k>0)
        {
            int n=pq.poll();
            pq.add((int)Math.floor(Math.sqrt(n)));
            k--;
        }
        
        long sum=0;
        while(!pq.isEmpty())
        {
            sum+=pq.poll();
        }
        return sum;
    }
}