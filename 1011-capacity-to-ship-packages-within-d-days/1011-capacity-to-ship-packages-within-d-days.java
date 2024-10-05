class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=Integer.MIN_VALUE,high=0;
        for(int i=0;i<weights.length;i++)
        {
            low=Math.max(low,weights[i]);
            high+=weights[i];
        }
        
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int daysCount=countDays(weights,mid);
            if(daysCount<=days)
            {
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    public int countDays(int[] weights,int cap)
    {
        int days=1,load=0;
        for(int i=0;i<weights.length;i++)
        {
            if(load+weights[i]>cap)
            {
                days++;
                load=weights[i];
            }else{
                load+=weights[i];
            }
        }
        return days;
    }
    
}