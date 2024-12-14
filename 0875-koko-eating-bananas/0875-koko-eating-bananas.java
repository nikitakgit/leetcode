class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       Arrays.sort(piles);
        int low=1,high=piles[piles.length-1];
        int ans=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int hr=calculateHr(piles,mid);
            if(hr<=h)
            {
                ans=Math.min(ans,mid);
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public int calculateHr(int[] piles,int hrly)
    {
        int hr=0;
        for(int i=0;i<piles.length;i++)
        {
            hr+=Math.ceil((double)piles[i]/(double)hrly);
        }
        return hr;
    }
    
}