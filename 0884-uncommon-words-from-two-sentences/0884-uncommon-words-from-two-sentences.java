class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        ArrayList<String> ans=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();
        String[] word1=s1.split(" ");
        String[] word2=s2.split(" ");
        
        for(String word:word1) map.put(word,map.getOrDefault(word,0)+1);
        for(String word:word2) map.put(word,map.getOrDefault(word,0)+1);
        
        for(Map.Entry<String,Integer> e:map.entrySet())
        {
            if(e.getValue()==1)
            {
                ans.add(e.getKey());
            }
        }
        
        return ans.toArray(new String[ans.size()]);
    }
}