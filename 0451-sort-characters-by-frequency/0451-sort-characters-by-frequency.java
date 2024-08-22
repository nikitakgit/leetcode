class Solution {
    public String frequencySort(String s) {
      HashMap<Character,Integer> map=new HashMap<>();
      for(char c:s.toCharArray())
      {
          map.put(c,map.getOrDefault(c,0)+1);
      }
        
        PriorityQueue<Map.Entry<Character,Integer>> pq=new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
        
        pq.addAll(map.entrySet());
        
        StringBuilder ans=new StringBuilder();
        while(!pq.isEmpty())
        {
            Map.Entry<Character,Integer> e=pq.poll();
            char key=e.getKey();
            int val=e.getValue();
            
            for(int i=0;i<val;i++)
            {
                ans.append(key);
            }
        }
        return ans.toString();
    }
}
