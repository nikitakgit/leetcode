class Solution {
    public long dividePlayers(int[] skill) {
        int n=skill.length;
        if(n%2!=0) return -1;
        Arrays.sort(skill);
        int req=skill[0]+skill[n-1];
        int l=0,r=n-1;
        long mul=0;
        while(l<r)
        {
            int currSum=skill[l]+skill[r];
            if(currSum==req)
            {
                mul+=skill[l]*skill[r];
                l++;
                r--;
            }else{
                return (long)-1;
            }
        }
        return mul;
    }
}