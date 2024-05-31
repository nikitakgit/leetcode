class Solution {
    public int deleteGreatestValue(int[][] grid) {
        
        int ans=0;
        for(int[] arr:grid)
        {
            Arrays.sort(arr);
        }
        
        for(int i=grid[0].length-1;i>=0;i--)
        {
            int max=1;
            for(int[] row:grid)
            {
                max=Math.max(row[i],max);
            }
            ans+=max;
        }
        return ans;
    }
}