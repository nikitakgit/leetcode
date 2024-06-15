class Solution {
    
    private class Project{
        int capital;
        int profit;
        
        Project(int capital,int profit)
        {
            this.capital=capital;
            this.profit=profit;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Project> projects=new ArrayList<>();
        int n=profits.length;
        for(int i=0;i<profits.length;i++)
        {
            projects.add(new Project(capital[i],profits[i]));
        }
        
        Collections.sort(projects,(a,b)->a.capital-b.capital);
        
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((x,y)-> y-x);
        int i=0;
        
        for(int j=0;j<k;j++)
        {
            while(i<n && projects.get(i).capital<=w)
            {
                maxHeap.add(projects.get(i).profit);
                i++;
            }
            
            if(maxHeap.isEmpty())
            {
                break;
            }
            
            w+=maxHeap.poll();
        }
        
        return w;
    }
}

   