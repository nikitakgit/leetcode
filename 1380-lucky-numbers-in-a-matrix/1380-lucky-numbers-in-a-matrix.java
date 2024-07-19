class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        
        List<Integer> ans=new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        int[] rmin=new int[m];
        int[] cmax=new int[n];
        
        for (int i = 0; i < m; i++) {
            rmin[i] = Integer.MAX_VALUE;
        }
        for (int j = 0; j < n; j++) {
            cmax[j] = Integer.MIN_VALUE;
        }
        
        for(int i=0;i<m;i++)
        {    
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]<rmin[i])
                {
                    rmin[i]=matrix[i][j];
                }
            }
        }
        
        for(int j=0;j<n;j++)
        {   
            for(int i=0;i<m;i++)
            {
                if(matrix[i][j]>cmax[j])
                {
                    cmax[j]=matrix[i][j];
                }
            }
        }
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==rmin[i] && matrix[i][j]==cmax[j])
                {
                    ans.add(matrix[i][j]);
                }
            }
        }
        return ans;
    }
}