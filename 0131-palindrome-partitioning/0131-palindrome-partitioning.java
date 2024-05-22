class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        helper(s,0,new ArrayList<>(),ans);
        return ans;
    }
    public void helper(String s,int i,List<String> path,List<List<String>> ans)
    {
        if(i==s.length())
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        
        for(int j=i+1;j<=s.length();j++)
        {
            if(isPalindrome(s,i,j-1))
            {
                path.add(s.substring(i,j));
                helper(s,j,path,ans);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s,int left,int right)
    {
        while(left<right)
        {
            if(s.charAt(left++)!=s.charAt(right--))
            {
                return false;
            }
        }
        return true;
    }
}

       