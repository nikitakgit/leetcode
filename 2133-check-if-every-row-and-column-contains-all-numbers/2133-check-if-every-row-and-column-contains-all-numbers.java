class Solution {
    public boolean checkValid(int[][] matrix) {
        Set seen=new HashSet<>();
        int n=matrix.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                String b="("+matrix[i][j]+")";
                if(!seen.add(b+i) || !seen.add(j+b))
                {
                    return false;
                }
            }
        }
        return true;
    }
}