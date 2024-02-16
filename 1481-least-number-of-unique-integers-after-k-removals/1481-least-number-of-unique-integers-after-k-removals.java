class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:arr)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        int unique=map.size();
        int[] cntArray=new int[100000];
        for(Integer key:map.keySet())
        {
            int keyCount=map.get(key);
            cntArray[keyCount]++;
        }
        
        for(int i=1;i<100000;i++)
        {
            if(cntArray[i]!=0)
            {
                int remove=k/i;
                if(remove==0) break;
                else{
                    remove=Math.min(remove,cntArray[i]);
                    unique-=remove;
                    k-=remove*i;
                }
            }
        }
        return unique;
    }
}
