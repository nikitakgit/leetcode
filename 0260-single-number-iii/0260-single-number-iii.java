class Solution {
    public int[] singleNumber(int[] nums) {
        ArrayList<Integer> arr=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        for(Map.Entry<Integer,Integer> e:map.entrySet())
        {
            if(e.getValue()==1)
            {
                arr.add(e.getKey());
            }
        }
        
        int[] result = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }
        return result;
    }
}