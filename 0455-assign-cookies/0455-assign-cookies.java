class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int m=g.length;
        int n=s.length;
        int l=0;
        int r=0;
        
        Arrays.sort(g);
        Arrays.sort(s);
        while(l<m && r<n)
        {
            if(s[r]>=g[l])
            {
                l++;
            }
            r++;
        }
        
        return l;
    }
}