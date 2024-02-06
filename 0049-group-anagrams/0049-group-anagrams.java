class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans=new ArrayList<>();
        Map<String ,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++)
        {
            char[] chars=strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted=new String(chars);
            
            if(!map.containsKey(sorted))
            {
                map.put(sorted,new ArrayList<>());
            }
            map.get(sorted).add(strs[i]);
        }
        
        for(List<String> grp:map.values())
        {
            ans.add(grp);
        }
        return ans;
    }
}
 