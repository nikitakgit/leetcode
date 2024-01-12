class Solution {
    
      int ub(int arr[], int key) {
      int mid, n=arr.length;
      int low = 0;
      int high = n;
      while (low < high && low != n) {
        mid = low + (high - low) / 2;
        if (key>=arr[mid]) low = mid + 1;
        else high = mid;
      }
      if (low==n) return -1;      
      return low;
    }

    int f(int[] days, int costs[], int i, int[] dp){
      if(i>days.length-1 || i==-1) return 0;
      if(dp[i]!=-1) return dp[i];
      int dayOne=costs[0]+f(days, costs, i+1, dp);
      int daySeven=costs[1]+f(days, costs, ub(days, days[i]+6), dp);
      int dayThirty=costs[2]+f(days, costs, ub(days, days[i]+29), dp);
      return dp[i]=Math.min(dayOne, Math.min(daySeven, dayThirty));
    }
    public int mincostTickets(int[] days, int[] costs) {
      int n=days.length;
      int[] dp=new int[n];
      Arrays.fill(dp, -1);
      return f(days, costs, 0, dp);   
    }
}