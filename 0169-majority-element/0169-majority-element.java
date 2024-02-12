class Solution {
    public int majorityElement(int[] nums) {
       HashMap<Integer,Integer> map=new HashMap<>();
       for(int i:nums)
       {
           map.put(i,map.getOrDefault(i,0)+1);
       }
        int t=(int)Math.floor(nums.length/2);
        int ans=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            if(entry.getValue()>t)
            {
                ans=entry.getKey();
                return ans;
            }
        }
        return ans;
    }
}