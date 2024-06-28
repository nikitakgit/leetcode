public class City{
    int ind;
    int degree;
    
    public City(int ind,int degree)
    {
        this.ind=ind;
        this.degree=degree;
    }
    
}

class Solution {
    public long maximumImportance(int n, int[][] roads) {
        //Array to store degree of each city
        int[] degree=new int[n];
        
        //calculate degree of each city
        for(int[] road:roads)
        {
            degree[road[0]]++;
            degree[road[1]]++;
        }
        
        //create a list of cities and sort by degree
        City[] cities=new City[n];
        for(int i=0;i<n;i++)
        {
            cities[i]=new City(i,degree[i]);
        }
        
        Arrays.sort(cities,(a,b)->b.degree-a.degree);
        
        //Assign values to cities starting from highest degree
        long totImp=0;
        for(int i=0;i<n;i++)
        {
            totImp+=(long)(n-i)*cities[i].degree;
        }
       return totImp;
    }
}