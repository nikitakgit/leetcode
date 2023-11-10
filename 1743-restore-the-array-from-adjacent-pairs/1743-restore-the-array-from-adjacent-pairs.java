class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
      Map<Integer,List<Integer>> graph=new HashMap<>(); 
      
      for(int [] pair:adjacentPairs)
      {
          graph.computeIfAbsent(pair[0],k->new ArrayList<>()).add(pair[1]);
          graph.computeIfAbsent(pair[1],k->new ArrayList<>()).add(pair[0]);
          
      }
        
        List<Integer> res=new ArrayList<>();
        for(Map.Entry<Integer,List<Integer>> entry:graph.entrySet())
        {
            if(entry.getValue().size()==1)
            {
                res.add(entry.getKey());
                res.add(entry.getValue().get(0));
                break;
            }
        }
        
        while(res.size()<adjacentPairs.length+1)
        {
            int last=res.get(res.size()-1);
            int prev=res.get(res.size()-2);
            List<Integer> candidates=graph.get(last);
            int nextElement=candidates.get(0)!=prev?candidates.get(0):candidates.get(1);
            res.add(nextElement);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}



        