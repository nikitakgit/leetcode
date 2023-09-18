class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] count1=new int[mat.length];
        for(int i=0;i<mat.length;i++)
        {
            int count=0;
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==1)
                {
                    count++;
                }
            }
            count1[i]=count;
        }

        List<Integer> l1=new ArrayList<>();
        for(int i=0;i<mat.length;i++)
        {
            l1.add(i);
        }

        Collections.sort(l1,(a,b)->{
            if(count1[a]==count1[b])
            {
                return a-b;
            }
            return count1[a]-count1[b];
        });

        int[] ans=new int[k];
        for(int i=0;i<k;i++)
        {
            ans[i]=l1.get(i);
        }
       return ans;
    }
}