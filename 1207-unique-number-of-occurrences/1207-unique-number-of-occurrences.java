class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:arr)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        HashSet<Integer> set=new HashSet<>();
        
        boolean flag=true;
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            if(!set.add(entry.getValue()))
            {
                flag=false;
            }
        }
        return flag;
    }
}