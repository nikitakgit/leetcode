class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n=piles.length;
       int low=1,high=piles[n-1];
        int ans=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int totalHr=calculateHr(piles,mid);
            if(totalHr<=h)
            {
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public int calculateHr(int[] piles,int hourly)
    {
        int totalHr=0;
        for(int i=0;i<piles.length;i++)
        {
            totalHr+=Math.ceil((double)piles[i]/(double)hourly);
        }
        return totalHr;
    }
    
}