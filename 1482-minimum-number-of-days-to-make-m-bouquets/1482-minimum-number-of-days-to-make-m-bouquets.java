class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
         if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int low = 1, high = (int) 1e9;
        int ans=high;
        while (low <=high) {
            int mid = low + (high - low) / 2;
            if(isPossibleBouquets(bloomDay,m,k,mid)==true)
            {
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    private boolean isPossibleBouquets(int[] bloomDay, int m, int k, int day) {
        int cnt=0,noOfB=0;
        for(int i=0;i<bloomDay.length;i++)
        {
            if(bloomDay[i]<=day)
            {
                cnt++;
                if(cnt==k)
                {
                    noOfB++;
                    cnt=0;
                }
            }else{
                cnt=0;
            }
        }
        
        if(noOfB>=m) return true;
        else return false;
    
    }
}