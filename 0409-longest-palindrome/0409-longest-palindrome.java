class Solution {
    public int longestPalindrome(String s) {
       int length=0;
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(set.contains(ch))
            {
                length+=2;
                set.remove(ch);
            }
            else{
                set.add(ch);
            }
        }
        if(set.size()>0)
        {
            length++;
        }
        return length; 
    }
}