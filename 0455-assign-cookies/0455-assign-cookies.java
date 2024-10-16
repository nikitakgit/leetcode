class Solution {
    public int findContentChildren(int[] g, int[] s) {
       int m=g.length;
        int n=s.length;
        int l=0,r=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(l<m && r<n)
        {
            if(g[l]<=s[r])
            {
                l++;
            }
            r++;
        }
        return l;
    }
}