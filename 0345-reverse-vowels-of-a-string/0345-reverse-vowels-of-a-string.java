class Solution {
    public String reverseVowels(String str) {
        Set<Character> s=new HashSet<>();
        s.add('a');
        s.add('e');
        s.add('i');
        s.add('o');
        s.add('u');
        s.add('A');
        s.add('E');
        s.add('I');
        s.add('O');
        s.add('U');
        ArrayList<Character> vowel=new ArrayList<>();
        for(int i=0;i<str.length();i++)
        {
            if(s.contains(str.charAt(i)))
            {
                vowel.add(str.charAt(i));
            }
        }
        
        String ans="";
        int j=vowel.size()-1;
        for(int i=0;i<str.length();i++)
        {
            if(!s.contains(str.charAt(i)))
            {
                ans+=str.charAt(i);
            }else{
                ans+=vowel.get(j);
                j--;
            }
        }
        return ans;
    }
}