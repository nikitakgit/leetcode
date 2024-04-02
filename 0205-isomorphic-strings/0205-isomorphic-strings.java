class Solution {
    public boolean isIsomorphic(String s, String t) {
         if(s.length()!=t.length())
        {
            return false;
        }

        HashMap<Character,Character> m=new HashMap<Character,Character>();
       for(int i=0;i<s.length();i++)
       {
           if(!m.containsKey(s.charAt(i)) && !m.containsValue(t.charAt(i)))
           {
               m.put(s.charAt(i),t.charAt(i));
           }else if(m.containsKey(s.charAt(i)) && m.get(s.charAt(i))==t.charAt(i))
           {
               continue;
           }else{
               return false;
           }
       }
       return true;
    }
}