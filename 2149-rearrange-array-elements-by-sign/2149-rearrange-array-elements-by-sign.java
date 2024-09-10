class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> a=new ArrayList<>();
        List<Integer> b=new ArrayList<>();
        List<Integer> c=new ArrayList<>();
        
        for(int i:nums)
        {
            if(i>0) a.add(i);
            else b.add(i);
        }
        
        int cnt=0,c1=0,c2=0;
        for(int num:nums)
        {
            if(cnt%2==0)
            {   int n=a.get(c1++);
                c.add(n);
            }else{
                int n=b.get(c2++);
                c.add(n);
            }
            cnt++;
        }
        
        int[] ans=new int[c.size()];
        for(int i=0;i<c.size();i++)
        {
            ans[i]=c.get(i);
        }
        return ans;
        
    }
}
