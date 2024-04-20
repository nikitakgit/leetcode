class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> res=new ArrayList<>();
        int m=land.length;
        int n=land[0].length;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(land[i][j]==1)
                {
                    int[] coordinates=dfs(land,i,j);
                    res.add(coordinates);
                }
            }
        }
        int[][] output=new int[res.size()][4];
        for(int i=0;i<res.size();i++)
        {
            output[i]=res.get(i);
        }
        return output;
    }
    private int[] dfs(int[][] land,int r,int c)
    {
        int m=land.length;
        int n=land[0].length;
        
        int[] coordinates=new int[4];
        coordinates[0]=r;
        coordinates[1]=c;
        
        int row=r;
        int col=c;
        
        while(row<m && land[row][c]==1) row++;
        while(col<n && land[r][col]==1) col++;
        
        coordinates[2]=row-1;
        coordinates[3]=col-1;
        
        for(int i=r;i<row;i++)
        {
            for(int j=c;j<col;j++)
            {
                land[i][j]=0;
            }
        }
        return coordinates;
    }
}
      

    