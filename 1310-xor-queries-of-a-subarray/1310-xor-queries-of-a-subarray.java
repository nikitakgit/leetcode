class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n=queries.length;
        int[] ans=new int[n];
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            int xor=0;
            int s=queries[i][0];
            int e=queries[i][1];
            for(int j=s;j<=e;j++)
            {
                xor^=arr[j];
            }
            ans[cnt++]=xor;
        }
        return ans;
    }
}