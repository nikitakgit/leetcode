class Solution {
    public int majorityElement(int[] nums) {
       HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        int k=(int)Math.floor(nums.length/2);
        int ans=0;
        for(Map.Entry<Integer,Integer> e:map.entrySet())
        {
            if(e.getValue()>k)
            {
                ans=e.getKey();
                break;
            }
        }
        return ans;
    }
}