class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int cnt=k;
        for(int i=0;i<nums.length;i++)
        {
            pq.offer(nums[i]);
        }
        while(cnt>1)
        {
            pq.poll();
            cnt--;
        }
        return pq.poll();
    }
}