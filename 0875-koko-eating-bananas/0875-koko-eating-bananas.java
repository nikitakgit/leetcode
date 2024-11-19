class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       Arrays.sort(piles);
        int l=1,r=piles[piles.length-1];
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(calculateHr(piles,mid)<=h)
            {
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
    public int calculateHr(int[] piles,int hourly)
    {
        int hr=0;
        for(int i=0;i<piles.length;i++)
        {
            hr+=Math.ceil((double)piles[i]/(double)hourly);
        }
        return hr;
    }
    
}