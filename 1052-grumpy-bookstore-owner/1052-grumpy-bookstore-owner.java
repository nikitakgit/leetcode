class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int i=0;
        int IniMax=0;
        int maxWin=0;
        for(int j=0;j<customers.length;j++)
        {
            IniMax=IniMax+customers[j]*grumpy[j];
            maxWin=Math.max(maxWin,IniMax);
            if(j>=minutes-1)
            {
                IniMax-=customers[i]*grumpy[i++];
            }
        }
        int res=maxWin;
        for(i=0;i<grumpy.length;i++)
        {
            res+=customers[i]*(1-grumpy[i]);
        }
        return res;
    }
}