class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        ArrayList<Integer> ans=new ArrayList<>();
        ArrayList<Integer> ans2=new ArrayList<>();
        HashMap<Integer,Integer> m=new HashMap<>();
        
        for(int num:arr1)
        {
            m.put(num,m.getOrDefault(num,0)+1);
        }
        
        for(int i=0;i<arr2.length;i++)
        {
            int t=m.get(arr2[i]);
                for(int j=0;j<t;j++)
                {
                    ans.add(arr2[i]);
                }
            m.put(arr2[i],0);
        }
        
        for(Map.Entry<Integer,Integer> e:m.entrySet())
        {
            int c=e.getValue();
            for(int j=0;j<c;j++)
                {
                    ans2.add(e.getKey());
                }
        }
        
        Collections.sort(ans2);
        
        int[] ans1=new int[ans.size()+ans2.size()];
        for(int i=0;i<ans.size();i++)
        {
            ans1[i]=ans.get(i);
        }
        for(int i=0;i<ans2.size();i++)
        {
            ans1[ans.size()+i]=ans2.get(i);
        }
        return ans1;
    }
}