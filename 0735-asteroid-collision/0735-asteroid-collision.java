class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> ls=new ArrayList<>();
        int n=asteroids.length;
        for(int i=0;i<n;i++)
        {
            if(asteroids[i]>0)
            {
                ls.add(asteroids[i]);
            }else{
                while(ls.size()!=0 && ls.get(ls.size()-1)>0 && ls.get(ls.size()-1)<Math.abs(asteroids[i]))
                {
                    ls.remove(ls.size()-1);
                }
                
                if(ls.size()==0 || ls.get(ls.size()-1)<0)
                {
                    ls.add(asteroids[i]);
                }else if(ls.get(ls.size()-1)==Math.abs(asteroids[i]))
                {
                    ls.remove(ls.size()-1);
                }
            }
        }
        
        int[] res=new int[ls.size()];
        for(int i=0;i<ls.size();i++)
        {
            res[i]=ls.get(i);
        }
        return res;
    }
}