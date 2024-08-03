class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] c1=new int[10001];
        int[] c2=new int[10001];
        
        for(int i:target)
        {
            c1[i]++;
        }
        
        for(int j:arr)
        {
            c2[j]++;
        }
        
        for(int i=0;i<c1.length;i++)
        {
            if(c1[i]!=c2[i]) return false;
        }
        return true;
    }
}